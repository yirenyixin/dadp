package com.gientech.sys.login;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysLoginDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "登陆名", required = true, position = 1)
	@NotBlank(message = "[loginName]登陆名，不能为空")
	private String loginName;// 登陆名

	@ApiModelProperty(value = "密码", required = true, position = 2)
	@NotBlank(message = "[password]密码，不能为空")
	private String password;// 密码

}
