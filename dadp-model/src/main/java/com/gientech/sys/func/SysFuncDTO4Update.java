package com.gientech.sys.func;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【功能】SysFunc修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "功能--修改DTO")
public class SysFuncDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "功能ID", required = true, position = 1)
	@NotBlank(message = "[funcId]功能ID，不能为空")
	@Size(max = 32, message = "功能ID，的长度必须小于等于32")
	private String funcId;// 功能ID

	@ApiModelProperty(value = "功能名称", required = true, position = 2)
	@NotBlank(message = "[funcName]功能名称，不能为空")
	@Size(max = 100, message = "功能名称，的长度必须小于等于100")
	private String funcName;// 功能名称

	@ApiModelProperty(value = "菜单ID", required = true, position = 3)
	@NotBlank(message = "[menuId]菜单ID，不能为空")
	@Size(max = 32, message = "菜单ID，的长度必须小于等于32")
	private String menuId;// 菜单ID

	@ApiModelProperty(value = "数据版本", required = true, position = 4)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}