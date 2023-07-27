package com.gientech.sys.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【菜单】SysMenu删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "菜单--删除DTO")
public class SysMenuDTO4Delete implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id", required = true, position = 1)
	@NotBlank(message = "[menuId]主键id，不能为空")
	@Size(max = 32, message = "主键id，的长度必须小于等于32")
	private String menuId;// 主键id

	// -----------------分割线---------------------------------------

}