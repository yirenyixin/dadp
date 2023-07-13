package com.gientech.sys.func;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

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