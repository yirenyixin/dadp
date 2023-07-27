package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【机构】SysOrg删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构--删除DTO")
public class SysOrgDTO4Delete implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id", required = true, position = 1)
	@NotBlank(message = "[orgId]主键id，不能为空")
	@Size(max = 32, message = "主键id，的长度必须小于等于32")
	private String orgId;// 主键id

	// -----------------分割线---------------------------------------

}