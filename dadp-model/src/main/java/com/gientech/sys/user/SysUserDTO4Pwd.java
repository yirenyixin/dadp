package com.gientech.sys.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【用户】SysUser查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "用户--查询条件的DTO类")
public class SysUserDTO4Pwd implements Serializable {

	private static final long serialVersionUID = 1L;

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "用户ID", position = 1)
	private String userId;// 用户ID

	@ApiModelProperty(value = "密码", position = 2)
	private String password;// 密码

}