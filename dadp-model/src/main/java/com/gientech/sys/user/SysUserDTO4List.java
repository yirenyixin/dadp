package com.gientech.sys.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "系统用户--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class SysUserDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前页码", required = true, position = 1)
	@NotNull(message = "[pageNo]当前页码不能为空")
	@Min(value = 1, message = "[pageNo]当前页码不能小于1")
	@Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码不能大于" + Integer.MAX_VALUE)
	private Integer pageNo; // 当前页码

	@ApiModelProperty(value = "每页大小", required = true, position = 2)
	@NotNull(message = "[pageSize]每页大小不能为空")
	@Min(value = 1, message = "[pageSize]每页大小不能小于1")
	@Max(value = 100, message = "[pageSize]每页大小不能超过{value}")
	private Integer pageSize; // 每页大小

	@ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
	private String sort; // 排序字段名,多个逗号分隔

	@ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
	private String order; // 按什么排序(asc,desc)

	@JsonIgnore
	private String orderBy; // 排序sql片段

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "用户ID", position = 13)
	private String userId; // 用户ID

	@ApiModelProperty(value = "用户姓名", position = 14)
	private String userName; // 用户姓名

	@ApiModelProperty(value = "登录名", position = 15)
	private String loginName; // 登录名

	@ApiModelProperty(value = "手机号", position = 16)
	private String tel; // 手机号

	@ApiModelProperty(value = "性别", position = 17)
	private String sex; // 性别

	@ApiModelProperty(value = "所属机构", position = 18)
	private String orgId; // 所属机构

	@ApiModelProperty(value = "法人机构号", position = 19)
	private String lawOrgId; // 法人机构号

	@ApiModelProperty(value = "身份证号码", position = 20)
	private String idCardNo; // 身份证号码

	@ApiModelProperty(value = "联系地址", position = 21)
	private String address; // 联系地址

	@ApiModelProperty(value = "邮箱", position = 22)
	private String email; // 邮箱

	@ApiModelProperty(value = "柜员号", position = 23)
	private String tellerNo; // 柜员号

	@ApiModelProperty(value = "从业年限", position = 24)
	private Integer workingYears; // 从业年限

	@ApiModelProperty(value = "微信号", position = 25)
	private String wechatNo; // 微信号

	@ApiModelProperty(value = "当前角色", position = 26)
	private String roleId; // 当前角色

	@ApiModelProperty(value = "用户状态", position = 27)
	private String status; // 用户状态

	@ApiModelProperty(value = "排序号", position = 28)
	private Integer sortNo; // 排序号

	// -----------------分割线---------------------------------------

}




