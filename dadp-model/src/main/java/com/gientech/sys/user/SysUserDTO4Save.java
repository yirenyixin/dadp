package com.gientech.sys.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "系统用户--更新DTO")
public class SysUserDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", required = true, position = 1)
	@NotBlank(message = "[userId] 用户ID不能为空")
	@Size(max = 32, message = "用户ID的长度必须小于等于32")
	private String userId; // 用户ID

	@ApiModelProperty(value = "用户姓名", required = true, position = 2)
	@NotBlank(message = "[userName] 用户姓名不能为空")
	@Size(max = 100, message = "用户姓名的长度必须小于等于100")
	private String userName; // 用户姓名

	@ApiModelProperty(value = "登录名", required = true, position = 3)
	@NotBlank(message = "[loginName] 登录名不能为空")
	@Size(max = 100, message = "登录名的长度必须小于等于100")
	private String loginName; // 登录名

	@ApiModelProperty(value = "手机号", position = 4)
	@Size(max = 50, message = "手机号的长度必须小于等于50")
	private String tel; // 手机号

	@ApiModelProperty(value = "密码", position = 5)
	@NotBlank(message = "[password] 密码不能为空")
	@Size(max = 100, message = "密码的长度必须小于等于100")
	private String password; // 密码

	@ApiModelProperty(value = "性别", position = 6)
	@Size(max = 1, message = "性别的长度必须小于等于1")
	private String sex; // 性别

	@ApiModelProperty(value = "所属机构", position = 7)
	@Size(max = 32, message = "所属机构的长度必须小于等于32")
	private String orgId; // 所属机构

	@ApiModelProperty(value = "所属机构地址", position = 8)
	@Size(max = 128, message = "所属机构地址的长度必须小于等于128")
	private String orgAddr; // 所属机构地址

	@ApiModelProperty(value = "法人机构号", position = 9)
//	@NotBlank(message = "[lawOrgId] 法人机构号不能为空")
	@Size(max = 32, message = "法人机构号的长度必须小于等于32")
	private String lawOrgId; // 法人机构号

	@ApiModelProperty(value = "身份证号码", position = 10)
//	@NotBlank(message = "[idCardNo] 身份证号码不能为空")
	@Size(max = 20, message = "身份证号码的长度必须小于等于20")
	private String idCardNo; // 身份证号码

	@ApiModelProperty(value = "联系地址", position = 11)
	@Size(max = 120, message = "联系地址的长度必须小于等于120")
	private String addr; // 联系地址

	@ApiModelProperty(value = "邮箱", position = 12)
	@Size(max = 50, message = "邮箱的长度必须小于等于50")
	private String email; // 邮箱

	@ApiModelProperty(value = "柜员号", position = 13)
	@Size(max = 30, message = "柜员号的长度必须小于等于30")
	private String tellerNo; // 柜员号

	@ApiModelProperty(value = "从业年限", position = 14)
	private Integer workingYears; // 从业年限

	@ApiModelProperty(value = "微信号", position = 15)
	@Size(max = 32, message = "微信号的长度必须小于等于32")
	private String wechatNo; // 微信号

	@ApiModelProperty(value = "当前角色", position = 16)
	@Size(max = 32, message = "当前角色的长度必须小于等于32")
	private String roleId; // 当前角色

	@ApiModelProperty(value = "拥有的全部角色", position = 17)
	@Size(max = 320, message = "拥有的全部角色的长度必须小于等于320")
	private String roleIds; // 拥有的全部角色

	@ApiModelProperty(value = "用户状态", position = 18)
	@Size(max = 1, message = "用户状态的长度必须小于等于1")
	private String status; // 用户状态

	@ApiModelProperty(value = "排序号", position = 19)
	private Integer sortNo; // 排序号

	@ApiModelProperty(value = "备注", position = 20)
	@Size(max = 400, message = "备注的长度必须小于等于400")
	private String remark; // 备注

	@ApiModelProperty(value = "版本号", position = 21)
	private Integer ver; // 版本号

	// Getters and setters
}