package com.gientech.sys.codeType;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【代码类别】SysCodeType删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "代码类别--删除DTO")
public class SysCodeTypeDTO4Delete implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键ids,逗号分隔", required = true, position = 1)
	@NotBlank(message = "[codeTypeIds]主键ids，不能为空")
	@Size(max = 400, message = "主键ids，的长度必须小于等于400")
	private String codeTypeIds;// 主键ids,逗号分隔

	// -----------------分割线---------------------------------------

}