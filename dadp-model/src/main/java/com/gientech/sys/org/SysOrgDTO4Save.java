package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 【机构】SysOrg新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构--新增DTO")
public class SysOrgDTO4Save implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "机构ID", required = true, position = 1)
	@NotBlank(message = "[orgId]机构ID，不能为空")
	@Size(max = 32, message = "机构ID的长度必须小于等于32")
	private String orgId;// 机构ID

	@ApiModelProperty(value = "机构名称", required = true, position = 2)
	@NotBlank(message = "[orgName]机构名称，不能为空")
	@Size(max = 100, message = "机构名称的长度必须小于等于100")
	private String orgName;// 机构名称

	@ApiModelProperty(value = "上级机构ID", position = 3)
	@Size(max = 32, message = "上级机构ID的长度必须小于等于32")
	private String parentOrgId;// 上级机构ID

	@ApiModelProperty(value = "排序号", required = true, position = 6)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "[sortNo]排序号不能小于0")
	@Max(value = 99999, message = "[sortNo]排序号不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 7)
	@Size(max = 400, message = "备注的长度必须小于等于400")
	private String remark;// 备注

	// -----------------分割线---------------------------------------

}