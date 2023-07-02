package com.gientech.sys.org;

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
 * 【机构】SysOrg修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构--修改DTO")
public class SysOrgDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构ID", required = true, position = 1)
	@NotBlank(message = "[orgId]机构ID，不能为空")
	@Size(max = 32, message = "机构ID，的长度必须小于等于32")
	private String orgId;// 机构ID

	@ApiModelProperty(value = "机构名称", required = true, position = 2)
	@NotBlank(message = "[orgName]机构名称，不能为空")
	@Size(max = 100, message = "机构名称，的长度必须小于等于100")
	private String orgName;// 机构名称

	@ApiModelProperty(value = "上级机构ID", position = 3)
	@Size(max = 32, message = "上级机构ID，的长度必须小于等于32")
	private String parentOrgId;// 上级机构ID

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