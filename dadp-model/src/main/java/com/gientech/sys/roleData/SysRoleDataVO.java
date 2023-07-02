package com.gientech.sys.roleData;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【数据权限】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysRoleDataVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "数据权限ID", position = 1)
	private String roleDataId;// 数据权限ID

	@ApiModelProperty(value = "角色ID", position = 2)
	private String roleId;// 角色ID

	@ApiModelProperty(value = "业务表名", position = 3)
	private String tableName;// 业务表名

	@ApiModelProperty(value = "权限类型", position = 4)
	private String authType;// 权限类型

	@ApiModelProperty(value = "权限范围ID", position = 5)
	private String authScopeId;// 权限范围ID

	@ApiModelProperty(value = "数据范围名", position = 6)
	private String authScopeName;// 数据范围名

	@ApiModelProperty(value = "是否含下级", position = 7)
	private String isIncludeSub;// 是否含下级

	@ApiModelProperty(value = "数据版本", position = 8)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}