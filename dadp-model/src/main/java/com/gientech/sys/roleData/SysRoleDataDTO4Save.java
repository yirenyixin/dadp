package com.gientech.sys.roleData;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【数据权限】SysRoleData新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "数据权限--新增DTO")
public class SysRoleDataDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID", required = true, position = 2)
	@NotBlank(message = "[roleId]角色ID，不能为空")
	@Size(max = 32, message = "角色ID的长度必须小于等于32")
	private String roleId;// 角色ID

	@ApiModelProperty(value = "业务表名", required = true, position = 3)
	@NotBlank(message = "[tableName]业务表名，不能为空")
	@Size(max = 100, message = "业务表名的长度必须小于等于100")
	private String tableName;// 业务表名

	@ApiModelProperty(value = "权限类型", required = true, position = 4)
	@NotBlank(message = "[authType]权限类型，不能为空")
	@Size(max = 1, message = "权限类型的长度必须小于等于1")
	private String authType;// 权限类型

	@ApiModelProperty(value = "权限范围ID", required = true, position = 5)
	@NotBlank(message = "[authScopeId]权限范围ID，不能为空")
	@Size(max = 32, message = "权限范围ID的长度必须小于等于32")
	private String authScopeId;// 权限范围ID

	@ApiModelProperty(value = "数据范围名", required = true, position = 6)
	@NotBlank(message = "[authScopeName]数据范围名，不能为空")
	@Size(max = 100, message = "数据范围名的长度必须小于等于100")
	private String authScopeName;// 数据范围名

	@ApiModelProperty(value = "是否含下级", required = true, position = 7)
	@NotBlank(message = "[isIncludeSub]是否含下级，不能为空")
	@Size(max = 1, message = "是否含下级的长度必须小于等于1")
	private String isIncludeSub;// 是否含下级

	// -----------------分割线---------------------------------------

}