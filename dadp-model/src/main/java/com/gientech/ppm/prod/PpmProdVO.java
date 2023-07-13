package com.gientech.ppm.prod;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PpmProdVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "产品编号", position = 1)
    private String prodId;

    @ApiModelProperty(value = "产品名称", position = 2)
    private String prodName;

    @ApiModelProperty(value = "目录编号", position = 3)
    private String kindId;

    @ApiModelProperty(value = "产品状态", position = 4)
    private String prodStatus;

    @ApiModelProperty(value = "产品介绍", position = 5)
    private String proDescribe;

    @ApiModelProperty(value = "办理流程及所需材料", position = 6)
    private String doFlow;

    @ApiModelProperty(value = "营销话术", position = 7)
    private String marketDiscourse;

    @ApiModelProperty(value = "产品特征", position = 8)
    private String prodFeature;

    // Getters and setters
}