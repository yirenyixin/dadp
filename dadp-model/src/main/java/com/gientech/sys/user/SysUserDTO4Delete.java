package com.gientech.sys.user;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "系统用户--删除DTO")
public class SysUserDTO4Delete implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "主键ids，逗号分隔", required = true, position = 1)
	@NotBlank(message = "[userIds]主键ids不能为空")
	@Size(max = 32, message = "主键ids的长度必须小于等于32")
	private String userIds; // 主键ids，逗号分隔

	// 可以根据需要添加其他属性或方法

}