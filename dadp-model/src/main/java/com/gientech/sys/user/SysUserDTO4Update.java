package com.gientech.sys.user;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【用户】SysUser修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "用户--修改DTO")
public class SysUserDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", required = true, position = 1)
	@NotBlank(message = "[userId]用户ID，不能为空")
	@Size(max = 32, message = "用户ID，的长度必须小于等于32")
	private String userId;// 用户ID

	@ApiModelProperty(value = "用户姓名", required = true, position = 2)
	@NotBlank(message = "[userName]用户姓名，不能为空")
	@Size(max = 100, message = "用户姓名，的长度必须小于等于100")
	private String userName;// 用户姓名

	@ApiModelProperty(value = "登陆名", required = true, position = 3)
	@NotBlank(message = "[loginName]登陆名，不能为空")
	@Size(max = 100, message = "登陆名，的长度必须小于等于100")
	private String loginName;// 登陆名

	@ApiModelProperty(value = "手机号", required = true, position = 4)
	@NotBlank(message = "[tel]手机号，不能为空")
	@Size(max = 50, message = "手机号，的长度必须小于等于50")
	private String tel;// 手机号

	@ApiModelProperty(value = "密码", required = true, position = 5)
	@NotBlank(message = "[password]密码，不能为空")
	@Size(max = 100, message = "密码，的长度必须小于等于100")
	private String password;// 密码

	@ApiModelProperty(value = "性别", required = true, position = 6)
	@NotBlank(message = "[sex]性别，不能为空")
	@Size(max = 1, message = "性别，的长度必须小于等于1")
	private String sex;// 性别

	@ApiModelProperty(value = "所属机构", required = true, position = 7)
	@NotBlank(message = "[orgId]所属机构，不能为空")
	@Size(max = 32, message = "所属机构，的长度必须小于等于32")
	private String orgId;// 所属机构

	@ApiModelProperty(value = "当前角色", required = true, position = 8)
	@NotBlank(message = "[roleId]当前角色，不能为空")
	@Size(max = 32, message = "当前角色，的长度必须小于等于32")
	private String roleId;// 当前角色

	@ApiModelProperty(value = "拥有的全部角色", required = true, position = 9)
	@NotBlank(message = "[roleIds]拥有的全部角色，不能为空")
	@Size(max = 320, message = "拥有的全部角色，的长度必须小于等于320")
	private String roleIds;// 拥有的全部角色

	@ApiModelProperty(value = "用户状态", required = true, position = 10)
	@NotBlank(message = "[status]用户状态，不能为空")
	@Size(max = 1, message = "用户状态，的长度必须小于等于1")
	private String status;// 用户状态

	@ApiModelProperty(value = "排序号", required = true, position = 11)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "排序号，不能小于0")
	@Max(value = 9999999, message = "排序号，不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 12)
	@Size(max = 400, message = "备注，的长度必须小于等于400")
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", required = true, position = 13)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}