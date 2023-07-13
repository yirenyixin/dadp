package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 【机构】SysOrg查询DTO类(tree)【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构--查询DTO")
public class SysOrgDTO4List implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "上级节点id", position = 1)
	private String topOrgId;// 上级节点id

	// -----------------分割线---------------------------------------

}