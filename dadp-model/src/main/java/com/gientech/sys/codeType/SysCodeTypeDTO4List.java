package com.gientech.sys.codeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 【代码类别】SysCodeType查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "代码类别--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class SysCodeTypeDTO4List implements Serializable {

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

	@ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
	private String sort;// 排序字段名,多个逗号分隔

	@ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
	private String order;// 按什么排序(asc,desc)

	@JsonIgnore
	private String orderBy;// 排序sql片段

	// -----------------分割线---------------------------------------

	@ApiModelProperty(value = "代码类别ID", position = 13)
	private String codeTypeId;// 代码类别ID

	@ApiModelProperty(value = "代码类别名称", position = 14)
	private String codeTypeName;// 代码类别名称

	@ApiModelProperty(value = "是否拼音排序", position = 16)
	private String isPinyin;// 是否拼音排序

	@ApiModelProperty(value = "备注", position = 17)
	private String remark;// 备注

	// -----------------分割线---------------------------------------

}