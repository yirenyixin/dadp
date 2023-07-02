package com.gientech.sys.role;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 角色实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_ROLE")
public class SysRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "ROLE_ID", type = IdType.INPUT)
	private String roleId;// 角色ID

	@TableField(value = "ROLE_NAME")
	private String roleName;// 角色名称

	@TableField(value = "HOME_URL")
	private String homeUrl;// 登录后首页

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}