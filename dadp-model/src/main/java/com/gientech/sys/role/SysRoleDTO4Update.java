package com.gientech.sys.role;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * 【角色】SysRole修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "角色--修改DTO")
public class SysRoleDTO4Update implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID", required = true, position = 1)
	@NotBlank(message = "[roleId]角色ID，不能为空")
	@Size(max = 32, message = "角色ID，的长度必须小于等于32")
	private String roleId;// 角色ID

	@ApiModelProperty(value = "角色名称", required = true, position = 2)
	@NotBlank(message = "[roleName]角色名称，不能为空")
	@Size(max = 100, message = "角色名称，的长度必须小于等于100")
	private String roleName;// 角色名称

	@ApiModelProperty(value = "登录后首页", required = true, position = 3)
	@NotBlank(message = "[homeUrl]登录后首页，不能为空")
	@Size(max = 50, message = "登录后首页，的长度必须小于等于50")
	private String homeUrl;// 登录后首页

	@ApiModelProperty(value = "排序号", required = true, position = 4)
	@NotNull(message = "[sortNo]排序号，不能为空")
	@Min(value = 0, message = "排序号，不能小于0")
	@Max(value = 9999, message = "排序号，不能大于{value}")
	private Integer sortNo;// 排序号

	@ApiModelProperty(value = "备注", position = 5)
	@Size(max = 400, message = "备注，的长度必须小于等于400")
	private String remark;// 备注

	@ApiModelProperty(value = "数据版本", required = true, position = 6)
	@NotNull(message = "[ver]数据版本，不能为空")
	@Min(value = 0, message = "数据版本，不能小于0")
	@Max(value = 99999, message = "数据版本，不能大于{value}")
	private Integer ver;// 数据版本

	// -----------------分割线---------------------------------------

}