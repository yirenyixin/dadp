package com.gientech.ppm.prod;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "产品表--更新DTO")
public class PpmProdDTO4Update implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "PROD_ID", required = true, position = 1)
    @NotBlank(message = "[prodId] PROD_ID不能为空")
    @Size(max = 32, message = "PROD_ID的长度必须小于等于32")
    private String prodId; // 产品编号

    @ApiModelProperty(value = "PROD_NAME", required = true, position = 2)
//    @NotBlank(message = "[prodName] 产品名称不能为空")
    @Size(max = 100, message = "产品名称的长度必须小于等于100")
    private String prodName; // 产品名称

    @ApiModelProperty(value = "KIND_ID", required = true, position = 3)
//    @NotBlank(message = "[kindId] 目录编号不能为空")
    @Size(max = 32, message = "目录编号的长度必须小于等于32")
    private String kindId; // 目录编号

    @ApiModelProperty(value = "PROD_STATUS", required = true, position = 4)
//    @NotBlank(message = "[prodStatus] 产品状态不能为空")
    @Size(max = 32, message = "产品状态的长度必须小于等于32")
    private String prodStatus; // 产品状态

    @ApiModelProperty(value = "PRO_DESCRIBE", position = 5)
    @Size(max = 1000, message = "产品介绍的长度必须小于等于1000")
    private String proDescribe; // 产品介绍

    @ApiModelProperty(value = "DO_FLOW", position = 6)
    @Size(max = 1000, message = "办理流程及所需材料的长度必须小于等于1000")
    private String doFlow; // 办理流程及所需材料

    @ApiModelProperty(value = "MARKET_DISCOURSE", position = 7)
    @Size(max = 500, message = "营销话术的长度必须小于等于500")
    private String marketDiscourse; // 营销话术

    @ApiModelProperty(value = "PROD_FEATURE", position = 8)
    @Size(max = 15, message = "产品特征的长度必须小于等于15")
    private String prodFeature; // 产品特征

    // Getters and setters
}