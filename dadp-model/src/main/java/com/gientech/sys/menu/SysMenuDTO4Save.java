package com.gientech.sys.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 【菜单】SysMenu新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "菜单--新增DTO")
public class SysMenuDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单ID", required = true, position = 1)
	@NotBlank(message = "[menuId]菜单ID，不能为空")
	@Size(max = 32, message = "菜单ID的长度必须小于等于32")
	private String menuId;// 菜单ID

	@ApiModelProperty(value = "菜单名称", required = true, position = 2)
	@NotBlank(message = "[menuName]菜单名称，不能为空")
	@Size(max = 100, message = "菜单名称的长度必须小于等于100")
	private String menuName;// 菜单名称

	@ApiModelProperty(value = "上级菜单ID", position = 3)
	@Size(max = 32, message = "上级菜单ID的长度必须小于等于32")
	private String parentMenuId;// 上级菜单ID

	@ApiModelProperty(value = "菜单URL", position = 4)
	@Size(max = 400, message = "菜单URL的长度必须小于等于400")
	private String menuUrl;// 菜单URL

	@ApiModelProperty(value = "是否绝对路径", required = true, position = 5)
	@NotBlank(message = "[isAllPath]是否绝对路径，不能为空")
	@Size(max = 1, message = "是否绝对路径的长度必须小于等于1")
	private String isAllPath;// 是否绝对路径

	@ApiModelProperty(value = "图标地址", position = 6)
	@Size(max = 200, message = "图标地址的长度必须小于等于200")
	private String imageUrl;// 图标地址

	@ApiModelProperty(value = "是否显示", required = true, position = 7)
	@NotBlank(message = "[isShow]是否显示，不能为空")
	@Size(max = 1, message = "是否显示的长度必须小于等于1")
	private String isShow;// 是否显示

	@ApiModelProperty(value = "排序号", required = true, position = 8)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "[sortNo]排序号不能小于0")
	@Max(value = 99999, message = "[sortNo]排序号不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 9)
	@Size(max = 400, message = "备注的长度必须小于等于400")
	private String remark;// 备注

	// -----------------分割线---------------------------------------

}