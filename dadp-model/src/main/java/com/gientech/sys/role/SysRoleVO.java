package com.gientech.sys.role;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【角色】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysRoleVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID", position = 1)
	private String roleId;// 角色ID

	@ApiModelProperty(value = "角色名称", position = 2)
	private String roleName;// 角色名称

	@ApiModelProperty(value = "登录后首页", position = 3)
	private String homeUrl;// 登录后首页

	@ApiModelProperty(value = "排序号", position = 4)
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 5)
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", position = 6)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}