package com.gientech.pcm.depFixed;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "PCM_DEP_FIXED - PcmDepFixedDTO4Get")
public class PcmDepFixedDTO4Get implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "DEP_FIXED_ID", required = true, position = 1)
    @NotBlank(message = "[depFixedId] DEP_FIXED_ID is mandatory")
    @Size(max = 32, message = "DEP_FIXED_ID length must be less than or equal to 32")//长度小于32
    private String depFixedId; // ID


    // Getters and setters
}