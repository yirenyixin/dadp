package com.gientech.sys.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "用户表--更新DTO")
public class SysUserDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", required = true, position = 1)
	@NotBlank(message = "[userId] 用户ID不能为空")
	@Size(max = 32, message = "用户ID的长度必须小于等于32")
	private String userId;

	@ApiModelProperty(value = "用户姓名", required = true, position = 2)
	@NotBlank(message = "[userName] 用户姓名不能为空")
	@Size(max = 100, message = "用户姓名的长度必须小于等于100")
	private String userName;

	@ApiModelProperty(value = "登陆名", required = true, position = 3)
	@NotBlank(message = "[loginName] 登陆名不能为空")
	@Size(max = 100, message = "登陆名的长度必须小于等于100")
	private String loginName;

	@ApiModelProperty(value = "手机号", required = true, position = 4)
	@NotBlank(message = "[tel] 手机号不能为空")
	@Size(max = 50, message = "手机号的长度必须小于等于50")
	private String tel;

	@ApiModelProperty(value = "密码", required = true, position = 5)
	@NotBlank(message = "[password] 密码不能为空")
	@Size(max = 100, message = "密码的长度必须小于等于100")
	private String password;

	@ApiModelProperty(value = "性别", required = true, position = 6)
	@NotBlank(message = "[sex] 性别不能为空")
	@Size(max = 1, message = "性别的长度必须小于等于1")
	private String sex;

	@ApiModelProperty(value = "所属机构", required = true, position = 7)
	@NotBlank(message = "[orgId] 所属机构不能为空")
	@Size(max = 32, message = "所属机构的长度必须小于等于32")
	private String orgId;

	@ApiModelProperty(value = "所属机构地址", required = true, position = 8)
	@NotBlank(message = "[orgAddr] 所属机构地址不能为空")
	@Size(max = 128, message = "所属机构地址的长度必须小于等于128")
	private String orgAddr;

	@ApiModelProperty(value = "法人机构号", required = true, position = 9)
	@NotBlank(message = "[lawOrgId] 法人机构号不能为空")
	@Size(max = 32, message = "法人机构号的长度必须小于等于32")
	private String lawOrgId;

	@ApiModelProperty(value = "身份证号码", required = true, position = 10)
	@NotBlank(message = "[idCardNo] 身份证号码不能为空")
	@Size(max = 20, message = "身份证号码的长度必须小于等于20")
	private String idCardNo;

	@ApiModelProperty(value = "联系地址", required = true, position = 11)
	@NotBlank(message = "[addr] 联系地址不能为空")
	@Size(max = 120, message = "联系地址的长度必须小于等于120")
	private String addr;

	@ApiModelProperty(value = "邮箱", required = true, position = 12)
	@NotBlank(message = "[email] 邮箱不能为空")
	@Size(max = 50, message = "邮箱的长度必须小于等于50")
	private String email;

	@ApiModelProperty(value = "柜员号", required = true, position = 13)
	@NotBlank(message = "[tellerNo] 柜员号不能为空")
	@Size(max = 30, message = "柜员号的长度必须小于等于30")
	private String tellerNo;

	@ApiModelProperty(value = "从业年限", required = true, position = 14)
	private Integer workingYears;

	@ApiModelProperty(value = "微信号", required = true, position = 15)
	@NotBlank(message = "[wechatNo] 微信号不能为空")
	@Size(max = 32, message = "微信号的长度必须小于等于32")
	private String wechatNo;

	@ApiModelProperty(value = "当前角色", required = true, position = 16)
	@NotBlank(message = "[roleId] 当前角色不能为空")
	@Size(max = 32, message = "当前角色的长度必须小于等于32")
	private String roleId;

	@ApiModelProperty(value = "拥有的全部角色", required = true, position = 17)
	@NotBlank(message = "[roleIds] 拥有的全部角色不能为空")
	@Size(max = 320, message = "拥有的全部角色的长度必须小于等于320")
	private String roleIds;

	@ApiModelProperty(value = "用户状态", required = true, position = 18)
	@NotBlank(message = "[status] 用户状态不能为空")
	@Size(max = 1, message = "用户状态的长度必须小于等于1")
	private String status;

	@ApiModelProperty(value = "排序号", required = true, position = 19)
	private Integer sortNo;

	@ApiModelProperty(value = "备注", required = true, position = 20)
	@Size(max = 400, message = "备注的长度必须小于等于400")
	private String remark;

	@ApiModelProperty(value = "数据版本", required = true, position = 21)
	private Integer ver;

	// Getters and setters
}