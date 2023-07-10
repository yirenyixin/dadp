package com.gientech.pcm.depFixed;//package com.example.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私定期存款--删除DTO")
public class PcmDepFixedDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids,逗号分隔", required = true, position = 1)
    @NotBlank(message = "[depFixedIds]主键ids，不能为空")
    @Size(max = 32, message = "主键ids的长度必须小于等于32")
    private String depFixedIds; // 主键ids,逗号分隔

    // -----------------分割线---------------------------------------
}