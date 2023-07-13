package com.gientech.sys.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 【系统参数】SysConfig修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "系统参数--修改DTO")
public class SysConfigDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "系统参数ID", required = true, position = 1)
	@NotBlank(message = "[configId]系统参数ID，不能为空")
	@Size(max = 32, message = "系统参数ID，的长度必须小于等于32")
	private String configId;// 系统参数ID

	@ApiModelProperty(value = "系统参数名称", required = true, position = 2)
	@NotBlank(message = "[configName]系统参数名称，不能为空")
	@Size(max = 100, message = "系统参数名称，的长度必须小于等于100")
	private String configName;// 系统参数名称

	@ApiModelProperty(value = "系统参数值", required = true, position = 3)
	@NotBlank(message = "[configValue]系统参数值，不能为空")
	@Size(max = 400, message = "系统参数值，的长度必须小于等于400")
	private String configValue;// 系统参数值

	@ApiModelProperty(value = "排序号", required = true, position = 4)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "排序号，不能小于0")
	@Max(value = 9999, message = "排序号，不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 5)
	@Size(max = 400, message = "备注，的长度必须小于等于400")
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", required = true, position = 6)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}