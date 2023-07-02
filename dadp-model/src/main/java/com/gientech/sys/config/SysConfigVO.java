package com.gientech.sys.config;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【系统参数】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysConfigVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "系统参数ID", position = 1)
	private String configId;// 系统参数ID

	@ApiModelProperty(value = "系统参数名称", position = 2)
	private String configName;// 系统参数名称

	@ApiModelProperty(value = "系统参数值", position = 3)
	private String configValue;// 系统参数值

	@ApiModelProperty(value = "排序号", position = 4)
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 5)
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", position = 6)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}