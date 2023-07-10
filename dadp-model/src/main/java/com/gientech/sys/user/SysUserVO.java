package com.gientech.sys.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", position = 1)
	private String userId;

	@ApiModelProperty(value = "用户姓名", position = 2)
	private String userName;

	@ApiModelProperty(value = "登录名", position = 3)
	private String loginName;

	@ApiModelProperty(value = "手机号", position = 4)
	private String tel;

	@ApiModelProperty(value = "密码", position = 5)
	private String password;

	@ApiModelProperty(value = "性别", position = 6)
	private String sex;

	@ApiModelProperty(value = "所属机构", position = 7)
	private String orgId;

	@ApiModelProperty(value = "所属机构地址", position = 8)
	private String orgAddr;

	@ApiModelProperty(value = "法人机构号", position = 9)
	private String lawOrgId;

	@ApiModelProperty(value = "身份证号码", position = 10)
	private String idCardNo;

	@ApiModelProperty(value = "联系地址", position = 11)
	private String addr;

	@ApiModelProperty(value = "邮箱", position = 12)
	private String email;

	@ApiModelProperty(value = "柜员号", position = 13)
	private String tellerNo;

	@ApiModelProperty(value = "从业年限", position = 14)
	private Integer workingYears;

	@ApiModelProperty(value = "微信号", position = 15)
	private String wechatNo;

	@ApiModelProperty(value = "当前角色", position = 16)
	private String roleId;

	@ApiModelProperty(value = "拥有的全部角色", position = 17)
	private String roleIds;

	@ApiModelProperty(value = "用户状态", position = 18)
	private String status;

	@ApiModelProperty(value = "排序号", position = 19)
	private Integer sortNo;

	@ApiModelProperty(value = "备注", position = 20)
	private String remark;

	@ApiModelProperty(value = "版本号", position = 21)
	private Integer ver;

	// Getters and setters
}