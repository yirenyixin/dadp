package com.gientech.sys.func;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【功能】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysFuncVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "功能ID", position = 1)
	private String funcId;// 功能ID

	@ApiModelProperty(value = "功能名称", position = 2)
	private String funcName;// 功能名称

	@ApiModelProperty(value = "菜单ID", position = 3)
	private String menuId;// 菜单ID

	@ApiModelProperty(value = "数据版本", position = 4)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}