package com.gientech.sys.codeType;

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
 * 【代码类别】SysCodeType新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "代码类别--新增DTO")
public class SysCodeTypeDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "代码类别ID", required = true, position = 1)
	@NotBlank(message = "[codeTypeId]代码类别ID，不能为空")
	@Size(max = 32, message = "代码类别ID的长度必须小于等于32")
	private String codeTypeId;// 代码类别ID

	@ApiModelProperty(value = "代码类别名称", required = true, position = 2)
	@NotBlank(message = "[codeTypeName]代码类别名称，不能为空")
	@Size(max = 100, message = "代码类别名称的长度必须小于等于100")
	private String codeTypeName;// 代码类别名称

	@ApiModelProperty(value = "排序号", required = true, position = 3)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "[sortNo]排序号不能小于0")
	@Max(value = 99999, message = "[sortNo]排序号不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "是否拼音排序", required = true, position = 4)
	@NotBlank(message = "[isPinyin]是否拼音排序，不能为空")
	@Size(max = 32, message = "是否拼音排序的长度必须小于等于32")
	private String isPinyin;// 是否拼音排序

	@ApiModelProperty(value = "备注", position = 5)
	@Size(max = 400, message = "备注的长度必须小于等于400")
	private String remark;// 备注

	// -----------------分割线---------------------------------------

}