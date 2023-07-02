package com.gientech.core.security.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gientech.common.MyConstants;
import com.gientech.common.auth.UserSession;
import com.gientech.common.exception.SessionOutException;
import com.gientech.core.redis.RedisService;
import com.gientech.core.security.util.HttpUtil;
import com.gientech.core.security.util.JwtUtil;

/**
 * token验证处理
 * 
 */
@Component
public class TokenService {

	@Autowired
	private RedisService redisService;

	/**
	 * 【1】获取当前用户的UserSession
	 * 
	 * @return
	 */
	public UserSession getUserSession() {
		// 1、根据token，拿到当前用户userId
		String userId = JwtUtil.getUserIdFromToken();

		UserSession userSession = (UserSession) this.redisService.get(MyConstants.REDIS_SESSION_ID + userId);

		// 2、如果没找到，抛异常
		if (userSession == null) {
			throw new SessionOutException();
		}

		return userSession;
	}

	/**
	 * 【1a】获取当前用户的UserSession【日志拦截专用】
	 * 
	 * @return
	 */
	public UserSession getUserSession2() {
		// 1、得到token
		String token = HttpUtil.getRequest().getHeader(MyConstants.HEADER);
		if (StringUtils.isNotEmpty(token) && token.startsWith(MyConstants.TOKEN_PREFIX)) {
			token = token.replace(MyConstants.TOKEN_PREFIX, "");
		}

		// 2、没登录呢
		if (StringUtils.isEmpty(token)) {
			return null;
		}

		// 3、从token得到userId，去redis去UserSession
		String userId = JwtUtil.getUserIdFromToken(token);

		UserSession userSession = (UserSession) this.redisService.get(MyConstants.REDIS_SESSION_ID + userId);

		return userSession;// 有可能是null
	}

}