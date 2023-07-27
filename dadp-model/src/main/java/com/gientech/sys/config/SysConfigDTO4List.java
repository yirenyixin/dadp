package com.gientech.sys.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 【系统参数】SysConfig查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "系统参数--查询条件的DTO类")
public class SysConfigDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "当前页码", required = true, position = 1)
	@NotNull(message = "[pageNo]当前页码，不能为空")
	@Min(value = 1, message = "[pageNo]当前页码，不能小于1")
	@Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
	private Integer pageNo;// 当前页码

	@ApiModelProperty(value = "每页大小", required = true, position = 2)
	@NotNull(message = "[pageSize]每页大小，不能为空")
	@Min(value = 1, message = "[pageSize]每页大小，不能小于1")
	@Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
	private Integer pageSize;// 每页大小

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "系统参数ID", position = 13)
	private String configId;// 系统参数ID

	@ApiModelProperty(value = "系统参数名称", position = 14)
	private String configName;// 系统参数名称

	@ApiModelProperty(value = "系统参数值", position = 15)
	private String configValue;// 系统参数值

	// -----------------分割线---------------------------------------

}