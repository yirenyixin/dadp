package com.gientech.pcm.loan;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私贷款--获取DTO")
public class PcmLoanDTO4Get implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id", required = true, position = 1)
    @NotBlank(message = "[loanId]主键id不能为空")
    @Size(max = 32, message = "主键id的长度必须小于等于32")
    private String loanId; // 主键id

    // 添加其他属性或方法，根据需要自行扩展

}