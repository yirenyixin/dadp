package com.gientech.sys.cache;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysCacheDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "下拉框ID,多个用都好分隔", required = false, position = 1)
	private String codeTypeId;// 下拉框ID,多个用都好分隔
}
