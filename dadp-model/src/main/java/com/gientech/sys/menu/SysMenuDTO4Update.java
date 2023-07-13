package com.gientech.sys.menu;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 【菜单】SysMenu修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "菜单--修改DTO")
public class SysMenuDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "菜单ID", required = true, position = 1)
	@NotBlank(message = "[menuId]菜单ID，不能为空")
	@Size(max = 32, message = "菜单ID，的长度必须小于等于32")
	private String menuId;// 菜单ID

	@ApiModelProperty(value = "菜单名称", required = true, position = 2)
	@NotBlank(message = "[menuName]菜单名称，不能为空")
	@Size(max = 100, message = "菜单名称，的长度必须小于等于100")
	private String menuName;// 菜单名称

	@ApiModelProperty(value = "上级菜单ID", position = 3)
	@Size(max = 32, message = "上级菜单ID，的长度必须小于等于32")
	private String parentMenuId;// 上级菜单ID

	@ApiModelProperty(value = "菜单URL", position = 4)
	@Size(max = 400, message = "菜单URL，的长度必须小于等于400")
	private String menuUrl;// 菜单URL

	@ApiModelProperty(value = "是否绝对路径", required = true, position = 5)
	@NotBlank(message = "[isAllPath]是否绝对路径，不能为空")
	@Size(max = 1, message = "是否绝对路径，的长度必须小于等于1")
	private String isAllPath;// 是否绝对路径

	@ApiModelProperty(value = "图标地址", position = 6)
	@Size(max = 200, message = "图标地址，的长度必须小于等于200")
	private String imageUrl;// 图标地址

	@ApiModelProperty(value = "是否显示", required = true, position = 7)
	@NotBlank(message = "[isShow]是否显示，不能为空")
	@Size(max = 1, message = "是否显示，的长度必须小于等于1")
	private String isShow;// 是否显示

	@ApiModelProperty(value = "排序号", required = true, position = 8)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "排序号，不能小于0")
	@Max(value = 9999, message = "排序号，不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 9)
	@Size(max = 400, message = "备注，的长度必须小于等于400")
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", required = true, position = 10)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}