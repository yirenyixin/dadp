package com.gientech.sys.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "系统用户--获取DTO")
public class SysUserDTO4Get implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键id", required = true, position = 1)
	@NotBlank(message = "[userId]主键id不能为空")
	@Size(max = 32, message = "主键id的长度必须小于等于32")
	private String userId; // 主键id

	// 可以根据需要添加其他属性或方法

}