package com.gientech.core.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gientech.common.auth.UserSession;
import com.gientech.core.security.service.TokenService;

/**
 * 基础controller类，封装了常用方法
 * 
 * @author 胡砥峰，吴清赫
 *
 */
@Controller
@RequestMapping("/sys/base")
public class BaseController {

	@Autowired
	private TokenService tokenService;

	/**
	 * 【1】获取当前用户的UserSession
	 * 
	 * @return
	 */
	public UserSession getUserSession() {
		return this.tokenService.getUserSession();
	}

}
