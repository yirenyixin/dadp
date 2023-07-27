package com.gientech.sys.login;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
public class SysLoginDTO4ChangeRole implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "角色ID", required = true, position = 1)
	@NotBlank(message = "[roleId]角色ID，不能为空")
	private String roleId;// 角色ID

}
