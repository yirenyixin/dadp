package com.gientech.sys.roleAuth;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【操作权限】SysRoleAuth新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "操作权限--保存DTO")
public class SysRoleAuthDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID", required = true, position = 2)
	@NotBlank(message = "[roleId]角色ID，不能为空")
	@Size(max = 32, message = "角色ID的长度必须小于等于32")
	private String roleId;// 角色ID

	@ApiModelProperty(value = "菜单ID或功能ID", required = true, position = 3)
	@NotBlank(message = "被授权的菜单ID或功能ID不能为空")
	private String menuOrFuncIds;// 菜单或功能ID

	// -----------------分割线---------------------------------------

}