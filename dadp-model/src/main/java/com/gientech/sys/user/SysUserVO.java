package com.gientech.sys.user;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【用户】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysUserVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "用户ID", position = 1)
	private String userId;// 用户ID

	@ApiModelProperty(value = "用户姓名", position = 2)
	private String userName;// 用户姓名

	@ApiModelProperty(value = "登陆名", position = 3)
	private String loginName;// 登陆名

	@ApiModelProperty(value = "手机号", position = 4)
	private String tel;// 手机号

	@ApiModelProperty(value = "密码", position = 5)
	private String password;// 密码

	@ApiModelProperty(value = "性别", position = 6)
	private String sex;// 性别

	@ApiModelProperty(value = "所属机构", position = 7)
	private String orgId;// 所属机构

	@ApiModelProperty(value = "当前角色", position = 8)
	private String roleId;// 当前角色

	@ApiModelProperty(value = "拥有的全部角色", position = 9)
	private String roleIds;// 拥有的全部角色

	@ApiModelProperty(value = "用户状态", position = 10)
	private String status;// 用户状态

	@ApiModelProperty(value = "排序号", position = 11)
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 12)
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", position = 13)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "角色名称", position = 14)
	private String roleName;// 角色名称

	@ApiModelProperty(value = "机构名称", position = 15)
	private String orgName;// 机构名称
}