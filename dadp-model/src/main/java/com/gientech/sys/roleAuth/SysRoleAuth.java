package com.gientech.sys.roleAuth;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 操作权限实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_ROLE_AUTH")
public class SysRoleAuth implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ROLE_AUTH_ID", type = IdType.ASSIGN_ID)
	private String roleAuthId;// 操作权限ID

	@TableField(value = "ROLE_ID")
	private String roleId;// 角色ID

	@TableField(value = "AUTH_TYPE")
	private String authType;// 权限类型

	@TableField(value = "MENU_OR_FUNC_ID")
	private String menuOrFuncId;// 菜单或功能ID

}