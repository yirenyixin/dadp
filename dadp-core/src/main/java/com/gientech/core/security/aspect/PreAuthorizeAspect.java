package com.gientech.core.security.aspect;

import java.lang.reflect.Method;
import java.util.Collection;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.gientech.common.MyConstants;
import com.gientech.common.auth.UserSession;
import com.gientech.common.exception.PreAuthorizeException;
import com.gientech.core.security.annotation.PreAuthorize;
import com.gientech.core.security.service.TokenService;

/**
 * 权限控制--全局AOP
 * 
 * @author 胡砥峰
 *
 */
@Aspect
@Component
public class PreAuthorizeAspect {

	@Autowired
	private TokenService tokenService;

	@Around("@annotation(com.gientech.core.security.annotation.PreAuthorize)")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		Signature signature = point.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		PreAuthorize annotation = method.getAnnotation(PreAuthorize.class);

		if (annotation == null) {
			return point.proceed();
		}

		if (!StringUtils.isEmpty(annotation.hasAuth())) {
			if (hasAuth(annotation.hasAuth())) {
				return point.proceed();
			}
			throw new PreAuthorizeException();
		} else if (!StringUtils.isEmpty(annotation.hasAnyAuth())) {
			if (hasAnyAuth(annotation.hasAnyAuth())) {
				return point.proceed();
			}
			throw new PreAuthorizeException();
		} else if (!StringUtils.isEmpty(annotation.hasRole())) {
			if (hasRole(annotation.hasRole())) {
				return point.proceed();
			}
			throw new PreAuthorizeException();
		} else if (!StringUtils.isEmpty(annotation.hasAnyRole())) {
			if (hasAnyRole(annotation.hasAnyRole())) {
				return point.proceed();
			}
			throw new PreAuthorizeException();
		}

		return point.proceed();
	}

	/**
	 * 【1】验证用户是否具备某权限
	 * 
	 * @param authCode 权限字符串
	 * @return 用户是否具备某权限
	 */
	public boolean hasAuth(String authCode) {
		UserSession userSession = tokenService.getUserSession();

		if (StringUtils.isEmpty(userSession) || CollectionUtils.isEmpty(userSession.getAuths())) {
			return false;
		}

		return hasAuthCode(userSession.getAuths(), authCode);
	}

	/**
	 * 【2】验证用户是否具有以下任意一个权限
	 *
	 * @param authArray 权限列表
	 * @return 用户是否具有以下任意一个权限
	 */
	public boolean hasAnyAuth(String[] authArray) {
		UserSession userSession = tokenService.getUserSession();

		if (StringUtils.isEmpty(userSession) || CollectionUtils.isEmpty(userSession.getAuths())) {
			return false;
		}

		Collection<String> authSet = userSession.getAuths();
		for (String authCode : authArray) {
			if (authCode != null && hasAuthCode(authSet, authCode)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 【11】判断用户是否拥有某个角色
	 * 
	 * @param role 角色字符串
	 * @return 用户是否具备某角色
	 */
	public boolean hasRole(String role) {
		UserSession userSession = tokenService.getUserSession();
		if (StringUtils.isEmpty(userSession) || CollectionUtils.isEmpty(userSession.getRoles())) {
			return false;
		}

		for (String roleKey : userSession.getRoles()) {
			if (MyConstants.ADMIN.contains(roleKey) || roleKey.contains(role)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 【12】验证用户是否具有以下任意一个角色
	 *
	 * @param roles 角色列表
	 * @return 用户是否具有以下任意一个角色
	 */
	public boolean hasAnyRole(String[] roles) {
		UserSession userSession = tokenService.getUserSession();
		if (StringUtils.isEmpty(userSession) || CollectionUtils.isEmpty(userSession.getRoles())) {
			return false;
		}
		for (String role : roles) {
			if (hasRole(role)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 【21】判断是否包含权限
	 * 
	 * @param authSet  权限列表
	 * @param authCode 权限字符串
	 * @return 用户是否具备某权限
	 */
	private boolean hasAuthCode(Collection<String> authSet, String authCode) {
		return authSet.contains(authCode);
	}
}
