package com.gientech.sys.codeType;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 【代码类别】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysCodeTypeVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "代码类别ID", position = 1)
	private String codeTypeId;// 代码类别ID

	@ApiModelProperty(value = "代码类别名称", position = 2)
	private String codeTypeName;// 代码类别名称

	@ApiModelProperty(value = "排序号", position = 3)
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "是否拼音排序", position = 4)
	private String isPinyin;// 是否拼音排序

	@ApiModelProperty(value = "备注", position = 5)
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", position = 6)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}