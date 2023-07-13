package com.gientech.ppm.prod;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "T_PPM_PROD")
public class PpmProd implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PROD_ID", type = IdType.INPUT)
    private String prodId; // 产品编号

    @TableField(value = "PROD_NAME")
    private String prodName; // 产品名称

    @TableField(value = "KIND_ID")
    private String kindId; // 目录编号

    @TableField(value = "PROD_STATUS")
    private String prodStatus; // 产品状态

    @TableField(value = "PRO_DESCRIBE")
    private String proDescribe; // 产品介绍

    @TableField(value = "DO_FLOW")
    private String doFlow; // 办理流程及所需材料

    @TableField(value = "MARKET_DISCOURSE")
    private String marketDiscourse; // 营销话术

    @TableField(value = "PROD_FEATURE")
    private String prodFeature; // 产品特征

    // 省略Getter和Setter方法
}