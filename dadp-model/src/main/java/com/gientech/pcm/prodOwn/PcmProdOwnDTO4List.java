package com.gientech.pcm.prodOwn;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "持有产品表--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止SQL注入
public class PcmProdOwnDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码不能为空")
    @Min(value = 1, message = "[pageNo]当前页码不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码不能大于" + Integer.MAX_VALUE)
    private Integer pageNo; // 当前页码

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小不能为空")
    @Min(value = 1, message = "[pageSize]每页大小不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小不能超过{value}")
    private Integer pageSize; // 每页大小

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort; // 排序字段名,多个逗号分隔

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order; // 按什么排序(asc,desc)

    @JsonIgnore
    private String orderBy; // 排序SQL片段

    // -----------------分割线---------------------------------------

    @ApiModelProperty(value = "产品编号", position = 13)
    private String prodOwnId; // 产品编号

    @ApiModelProperty(value = "产品名称", position = 14)
    private String prodName; // 产品名称

    @ApiModelProperty(value = "目录编号", position = 15)
    private String kindId; // 目录编号

    @ApiModelProperty(value = "产品状态", position = 16)
    private String prodStatus; // 产品状态

    @ApiModelProperty(value = "产品介绍", position = 17)
    private String proDescribe; // 产品介绍

    @ApiModelProperty(value = "办理流程及所需材料", position = 18)
    private String doFlow; // 办理流程及所需材料

    @ApiModelProperty(value = "营销话术", position = 19)
    private String marketDiscourse; // 营销话术

    @ApiModelProperty(value = "产品特征", position = 20)
    private String prodFeature; // 产品特征

    // 添加其他属性或方法，根据需要自行扩展

}