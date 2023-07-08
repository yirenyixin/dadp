package com.gientech.pcm.depCurr;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私活期存款--获取DTO")
public class PcmDepCurrDTO4Get implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id", required = true, position = 1)
    @NotBlank(message = "[depCurrId]主键id，不能为空")
    @Size(max = 32, message = "主键id的长度必须小于等于32")
    private String depCurrId; // 主键id

    // -----------------分割线---------------------------------------

}