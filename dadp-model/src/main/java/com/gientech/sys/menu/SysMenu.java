package com.gientech.sys.menu;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;

import lombok.Data;

/**
 * 菜单实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_MENU")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "MENU_ID", type = IdType.INPUT)
	private String menuId;// 菜单ID

	@TableField(value = "MENU_NAME")
	private String menuName;// 菜单名称

	@TableField(value = "PARENT_MENU_ID")
	private String parentMenuId;// 上级菜单ID

	@TableField(value = "MENU_URL")
	private String menuUrl;// 菜单URL

	@TableField(value = "IS_ALL_PATH")
	private String isAllPath;// 是否绝对路径

	@TableField(value = "IMAGE_URL")
	private String imageUrl;// 图标地址

	@TableField(value = "IS_SHOW")
	private String isShow;// 是否显示

	@TableField(value = "SORT_NO")
	private Integer sortNo;// 排序号

	@TableField(value = "REMARK")
	private String remark;// 备注

	@TableField(value = "VER")
	@Version // 乐观锁,防止串改
	private Integer ver;// 数据版本

}