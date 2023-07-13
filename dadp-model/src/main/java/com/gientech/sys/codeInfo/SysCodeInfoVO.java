package com.gientech.sys.codeInfo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 【代码信息】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysCodeInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "代码信息ID", position = 1)
	private String codeInfoId;// 代码信息ID

	@ApiModelProperty(value = "代码类别ID", position = 2)
	private String codeTypeId;// 代码类别ID

	@ApiModelProperty(value = "下拉框值", position = 3)
	private String value;// 下拉框值

	@ApiModelProperty(value = "下拉框内容", position = 4)
	private String content;// 下拉框内容

	@ApiModelProperty(value = "上级联动下拉框值", position = 5)
	private String parentValue;// 上级联动下拉框值

	@ApiModelProperty(value = "排序号", position = 6)
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 7)
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", position = 8)
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}