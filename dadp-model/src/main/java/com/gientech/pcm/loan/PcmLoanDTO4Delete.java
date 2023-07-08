package com.gientech.pcm.loan;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私贷款--删除DTO")
public class PcmLoanDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids，逗号分隔", required = true, position = 1)
    @NotBlank(message = "[loanIds]主键ids不能为空")
    @Size(max = 400, message = "主键ids的长度必须小于等于400")
    private String loanIds; // 主键ids，逗号分隔

    // 添加其他属性或方法，根据需要自行扩展

}