package com.gientech.pcm.depCurr;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "对私活期存款--删除DTO")
public class PcmDepCurrDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids，逗号分隔", required = true, position = 1)
    @NotBlank(message = "[depCurrIds] 主键ids不能为空")
    @Size(max = 32, message = "主键ids的长度必须小于等于32")
    private String depCurrIds; // 主键ids，逗号分隔

    // 添加其他属性或方法，根据需要自行扩展

}