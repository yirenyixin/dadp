package com.gientech.ppm.prod;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "产品表--删除DTO")
public class PpmProdDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids，逗号分隔", required = true, position = 1)
    @NotBlank(message = "[prodIds]主键ids不能为空")
    @Size(max = 32, message = "主键ids的长度必须小于等于32")
    private String prodIds; // 主键ids，逗号分隔

    // 添加其他属性或方法，根据需要自行扩展

}