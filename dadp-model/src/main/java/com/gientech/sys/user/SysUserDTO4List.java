package com.gientech.sys.user;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【用户】SysUser查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "用户--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class SysUserDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前页码", required = true, position = 1)
	@NotNull(message = "[pageNo]当前页码，不能为空")
	@Min(value = 1, message = "[pageNo]当前页码，不能小于1")
	@Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
	private Integer pageNo;// 当前页码

	@ApiModelProperty(value = "每页大小", required = true, position = 2)
	@NotNull(message = "[pageSize]每页大小，不能为空")
	@Min(value = 1, message = "[pageSize]每页大小，不能小于1")
	@Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
	private Integer pageSize;// 每页大小

	@ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
	private String sort;// 排序字段名,多个逗号分隔

	@ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
	private String order;// 按什么排序(asc,desc)

	@JsonIgnore
	private String orderBy;// 排序sql片段

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "用户ID", position = 13)
	private String userId;// 用户ID

	@ApiModelProperty(value = "用户姓名", position = 14)
	private String userName;// 用户姓名

	@ApiModelProperty(value = "登陆名", position = 15)
	private String loginName;// 登陆名

	@ApiModelProperty(value = "手机号", position = 16)
	private String tel;// 手机号

	@ApiModelProperty(value = "性别", position = 18)
	private String sex;// 性别

	@ApiModelProperty(value = "所属机构", position = 19)
	private String orgId;// 所属机构

	@ApiModelProperty(value = "当前角色", position = 20)
	private String roleId;// 当前角色

	@ApiModelProperty(value = "用户状态", position = 22)
	private String status;// 用户状态

	// -----------------分割线---------------------------------------

}