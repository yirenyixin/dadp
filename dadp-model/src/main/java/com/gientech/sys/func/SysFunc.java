package com.gientech.sys.func;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 功能实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_FUNC")
public class SysFunc implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "FUNC_ID", type = IdType.INPUT)
	private String funcId;// 功能ID

	@TableField(value = "FUNC_NAME")
	private String funcName;// 功能名称

	@TableField(value = "MENU_ID")
	private String menuId;// 菜单ID

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}