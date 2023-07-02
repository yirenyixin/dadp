package com.gientech.sys.codeInfo;

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
 * 【代码信息】SysCodeInfo修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "代码信息--修改DTO")
public class SysCodeInfoDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "代码信息ID", required = true, position = 1)
	@NotBlank(message = "[codeInfoId]代码信息ID，不能为空")
	@Size(max = 19, message = "代码信息ID，的长度必须小于等于19")
	private String codeInfoId;// 代码信息ID

	@ApiModelProperty(value = "代码类别ID", required = true, position = 2)
	@NotBlank(message = "[codeTypeId]代码类别ID，不能为空")
	@Size(max = 32, message = "代码类别ID，的长度必须小于等于32")
	private String codeTypeId;// 代码类别ID

	@ApiModelProperty(value = "下拉框值", required = true, position = 3)
	@NotBlank(message = "[value]下拉框值，不能为空")
	@Size(max = 100, message = "下拉框值，的长度必须小于等于100")
	private String value;// 下拉框值

	@ApiModelProperty(value = "下拉框内容", required = true, position = 4)
	@NotBlank(message = "[content]下拉框内容，不能为空")
	@Size(max = 100, message = "下拉框内容，的长度必须小于等于100")
	private String content;// 下拉框内容

	@ApiModelProperty(value = "上级联动下拉框值", position = 5)
	@Size(max = 100, message = "上级联动下拉框值，的长度必须小于等于100")
	private String parentValue;// 上级联动下拉框值

	@ApiModelProperty(value = "排序号", required = true, position = 6)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "排序号，不能小于0")
	@Max(value = 9999, message = "排序号，不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 7)
	@Size(max = 400, message = "备注，的长度必须小于等于400")
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", required = true, position = 8)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}