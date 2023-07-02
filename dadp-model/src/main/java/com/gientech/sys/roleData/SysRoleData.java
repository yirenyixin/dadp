package com.gientech.sys.roleData;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 数据权限实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_ROLE_DATA")
public class SysRoleData implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ROLE_DATA_ID", type = IdType.ASSIGN_ID)
	private String roleDataId;// 数据权限ID

	@TableField(value = "ROLE_ID")
	private String roleId;// 角色ID

	@TableField(value = "TABLE_NAME")
	private String tableName;// 业务表名

	@TableField(value = "AUTH_TYPE")
	private String authType;// 权限类型

	@TableField(value = "AUTH_SCOPE_ID")
	private String authScopeId;// 权限范围ID

	@TableField(value = "AUTH_SCOPE_NAME")
	private String authScopeName;// 数据范围名

	@TableField(value = "IS_INCLUDE_SUB")
	private String isIncludeSub;// 是否含下级

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}