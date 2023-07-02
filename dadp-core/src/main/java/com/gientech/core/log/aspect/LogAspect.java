package com.gientech.core.log.aspect;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.gientech.common.auth.UserSession;
import com.gientech.common.enums.YesOrNo;
import com.gientech.common.util.IpUtil;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.security.service.TokenService;
import com.gientech.core.security.util.HttpUtil;
import com.gientech.sys.operLog.SysOperLog;
import com.gientech.sys.operLog.SysOperLogFeign;

import cn.hutool.json.JSONUtil;

/**
 * 操作日志记录处理
 * 
 */
@Aspect
@Component
public class LogAspect {
	private static final Logger log = LoggerFactory.getLogger(LogAspect.class);

	@Autowired
	private TokenService tokenService;

	@Autowired
	private SysOperLogFeign sysOperLogFeign;

	// 配置织入点
	@Pointcut("@annotation(com.gientech.core.log.annotation.OperLog)")
	public void logPointCut() {
	}

	/**
	 * 处理完请求后执行
	 *
	 * @param joinPoint 切点
	 */
	@AfterReturning(pointcut = "logPointCut()", returning = "jsonResult")
	public void doAfterReturning(JoinPoint joinPoint, Object jsonResult) {
		saveOperLog(joinPoint, null, jsonResult);
	}

	/**
	 * 拦截异常操作
	 * 
	 * @param joinPoint 切点
	 * @param e         异常
	 */
	@AfterThrowing(value = "logPointCut()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Exception e) {
		saveOperLog(joinPoint, e, null);
	}

	protected void saveOperLog(final JoinPoint joinPoint, final Exception e, Object jsonResult) {
		try {
			// 【1】获得注解
			OperLog operLog = getAnnotationLog(joinPoint);
			if (operLog == null) {
				return;
			}

			// 【2】组织SysOperLog对象
			SysOperLog sysOperLog = new SysOperLog();

			sysOperLog.setIsOk(String.valueOf(YesOrNo.YES.getValue()));

			// 请求的地址
			String ip = IpUtil.getIpAddr(HttpUtil.getRequest());

			sysOperLog.setIpAddr(ip);

			// 返回参数
			sysOperLog.setResult(StringUtils.substring(JSONUtil.toJsonStr(jsonResult), 0, 1000));// 错误信息

			sysOperLog.setReqUrl(HttpUtil.getRequest().getRequestURI());

			if (e != null) {
				sysOperLog.setIsOk(String.valueOf(YesOrNo.NO.getValue()));
				sysOperLog.setResult(StringUtils.substring(e.getMessage(), 0, 1000));// 错误信息
			}

			// 设置方法名称
			String className = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			sysOperLog.setReqMethod(className + "." + methodName + "()");

			// 设置请求方式
			sysOperLog.setReqMode(HttpUtil.getRequest().getMethod());

			// 处理设置注解上的参数
			getControllerMethodDescription(joinPoint, operLog, sysOperLog);

			// 写入用户信息
			UserSession userSession = tokenService.getUserSession2();
			if (userSession != null) {
				sysOperLog.setUserId(userSession.getUserId());
				sysOperLog.setOrgId(userSession.getOrgId());
			}

			// 保存数据库
			this.sysOperLogFeign.save(sysOperLog);
		} catch (Exception exp) {
			// 记录本地异常日志
			log.error("==前置通知异常==");
			log.error("异常信息:{}", exp.getMessage());
		}
	}

	/**
	 * 获取注解中对方法的描述信息 用于Controller层注解
	 * 
	 * @param operLog    注解日志
	 * @param sysOperLog 操作日志
	 * @throws Exception
	 */
	public void getControllerMethodDescription(JoinPoint joinPoint, OperLog operLog, SysOperLog sysOperLog) throws Exception {

		// 设置--操作类型
		sysOperLog.setOperType(String.valueOf(operLog.operType().ordinal()));

		// 设置--模块名称
		sysOperLog.setModuleName(operLog.title());

		// 设置--操作来源
		sysOperLog.setOperSource(String.valueOf(operLog.operSource().ordinal()));

		// 是否需要保存request，参数和值
		if (operLog.isSaveRequestData()) {
			// 获取参数的信息，传入到数据库中。
			setRequestValue(joinPoint, sysOperLog);
		}

	}

	/**
	 * 获取请求的参数，放到log中
	 * 
	 * @param sysOperLog 操作日志
	 * @throws Exception 异常
	 */
	private void setRequestValue(JoinPoint joinPoint, SysOperLog sysOperLog) throws Exception {
		String reqMode = sysOperLog.getReqMode();
		if (HttpMethod.PUT.name().equals(reqMode) || HttpMethod.POST.name().equals(reqMode)) {
			String reqParam = argsArrayToString(joinPoint.getArgs());
			sysOperLog.setReqParam(StringUtils.substring(reqParam, 0, 1000));// 最多1000字符
		}
	}

	/**
	 * 是否存在注解，如果存在就获取
	 */
	private OperLog getAnnotationLog(JoinPoint joinPoint) throws Exception {
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();

		if (method != null) {
			return method.getAnnotation(OperLog.class);
		}
		return null;
	}

	/**
	 * 参数拼装
	 */
	private String argsArrayToString(Object[] paramsArray) {
		String params = "";
		if (paramsArray != null && paramsArray.length > 0) {
			for (int i = 0; i < paramsArray.length; i++) {
				if (!isFilterObject(paramsArray[i])) {
					try {
						Object jsonObj = JSONUtil.toJsonStr(paramsArray[i]);
						params += jsonObj.toString() + " ";
					} catch (Exception e) {
					}
				}
			}
		}
		return params.trim();
	}

	/**
	 * 判断是否需要过滤的对象。
	 * 
	 * @param o 对象信息。
	 * @return 如果是需要过滤的对象，则返回true；否则返回false。
	 */
	public boolean isFilterObject(final Object o) {
		return o instanceof MultipartFile || o instanceof HttpServletRequest || o instanceof HttpServletResponse;
	}
}
