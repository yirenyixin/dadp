package com.gientech.core.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gientech.common.Result;
import com.gientech.common.enums.ResultCode;
import com.gientech.common.exception.AppException;
import com.gientech.common.exception.PreAuthorizeException;
import com.gientech.common.exception.SessionOutException;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常捕捉处理
 * 
 * @author 胡砥峰、吴清赫
 *
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	/**
	 * 【1】拦截Exception.class异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = Exception.class)
	public Result<Object> errorHandler(Exception e) {
		log.error("系统异常信息{}", e);// 打印堆信息

//		return Result.error("系统异常,请联系管理员");
		return Result.error(e.getMessage());// TODO 开发阶段直接返回异常信息，便于追踪问题
	}

	/**
	 * 【2】拦截AppException.class异常---业务提示异常
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = AppException.class)
	public Result<Object> errorHandler(AppException e) {
		log.error("业务异常信息{}", e.getMessage());

		if (e.getCode() != null) {
			return Result.error(e.getCode(), e.getMessage());
		} else {
			return Result.error(e.getMessage());
		}
	}

	/**
	 * 【3】拦截PreAuthorizeException.class异常---没有操作权限
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = PreAuthorizeException.class)
	public Result<Object> errorHandler(PreAuthorizeException e) {
		log.error("操作鉴权{}", e.getMessage());

		return Result.error(ResultCode.NO_AUTH.getCode(), ResultCode.NO_AUTH.getMsg());
	}

	/**
	 * 【4】拦截SessionOutException.class异常---登录过期
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = SessionOutException.class)
	public Result<Object> errorHandler(SessionOutException e) {
		log.error("session到期{}", e.getMessage());

		return Result.error(ResultCode.TIME_OUT.getCode(), ResultCode.TIME_OUT.getMsg());
	}

	/**
	 * 【4a】JWT到期
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value = ExpiredJwtException.class)
	public Result<Object> errorHandler(ExpiredJwtException e) {
		log.error("session到期{}", e.getMessage());

		return Result.error(ResultCode.TIME_OUT.getCode(), ResultCode.TIME_OUT.getMsg());
	}

	/**
	 * 【11】校验DTO传参验证异常
	 *
	 * @param e 错误信息集合
	 * @return 错误信息
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public Result<Object> validationBodyException(ConstraintViolationException e) {
		StringBuilder sb = new StringBuilder();

		Set<ConstraintViolation<?>> set = e.getConstraintViolations();
		set.forEach(action -> {
			if (sb.toString().length() == 0) {
				sb.append(action.getMessage());
			} else {
				sb.append("；" + action.getMessage());
			}
		});

		return Result.error(sb.toString());
	}

}
