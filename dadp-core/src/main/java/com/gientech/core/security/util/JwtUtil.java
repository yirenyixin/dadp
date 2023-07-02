package com.gientech.core.security.util;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.gientech.common.MyConstants;
import com.gientech.common.exception.SessionOutException;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * Jwt---工具类
 * 
 * @author 胡砥峰
 *
 */
@Component
public class JwtUtil {

	/**
	 * jwt秘钥
	 */
	private final static String JWT_SIGN_KEY = "1qaz@WSX";

	/**
	 * 【1】根据userId,生成jwt
	 * 
	 * @param userId
	 * @return
	 */
	public static String createToken(String userId) {
		String token = Jwts.builder().setSubject(userId).

				setExpiration(DateUtil.offsetSecond(new Date(), MyConstants.TOKEN_EXPIRE))

				.signWith(SignatureAlgorithm.HS512, JWT_SIGN_KEY)

				.compressWith(CompressionCodecs.GZIP).compact();

		return token;
	}

	/**
	 * 【2】 直接得到userId(自动获取token)
	 * 
	 * @return
	 */
	public static String getUserIdFromToken() {
		Claims claims = Jwts.parser().setSigningKey(JWT_SIGN_KEY).parseClaimsJws(getToken()).getBody();

		// 判断,到期时间
		if (DateUtil.between(claims.getExpiration(), new Date(), DateUnit.SECOND) < 0) {
			throw new SessionOutException();
		}

		return claims.getSubject();
	}

	/**
	 * 【2a】 通过token，得到userId
	 * 
	 * @param token
	 * @return
	 */
	public static String getUserIdFromToken(String token) {
		return Jwts.parser().setSigningKey(JWT_SIGN_KEY).parseClaimsJws(token).getBody().getSubject();
	}

	/**
	 * 【3】获取请求token
	 * 
	 * @return
	 */
	public static String getToken() {
		String token = HttpUtil.getRequest().getHeader(MyConstants.HEADER);

		// 【1】得到token
		if (StringUtils.isNotEmpty(token) && token.startsWith(MyConstants.TOKEN_PREFIX)) {
			token = token.replace(MyConstants.TOKEN_PREFIX, "");
		}

		// 【2】没有token，抛异常
		if (StringUtils.isEmpty(token)) {
			throw new SessionOutException();
		}

		return token;
	}

}
