package com.gientech.sys.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 【菜单】SysMenu查询DTO类(tree)【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "菜单--查询DTO")
public class SysMenuDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "上级节点id", position = 1)
	private String topMenuId;// 上级节点id

	// -----------------分割线---------------------------------------

}