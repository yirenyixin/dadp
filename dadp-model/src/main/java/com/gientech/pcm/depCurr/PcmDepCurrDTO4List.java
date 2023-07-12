package com.gientech.pcm.depCurr;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私活期存款--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class PcmDepCurrDTO4List implements Serializable {

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
    private String orderBy; // 排序sql片段

    // -----------------分割线---------------------------------------

    @ApiModelProperty(value = "ID", position = 13)
    private String depCurrId; // ID

    @ApiModelProperty(value = "客户ID", position = 14)
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF客户ID", position = 15)
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "客户名称", position = 16)
    private String custName; // 客户名称

    @ApiModelProperty(value = "法人机构号", position = 17)
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "产品代码", position = 18)
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "产品名称", position = 19)
    private String prodName; // 产品名称

    @ApiModelProperty(value = "账号/卡号", position = 20)
    private String acctNo; // 账号/卡号

    @ApiModelProperty(value = "币种", position = 21)
    private String currNo; // 币种

    @ApiModelProperty(value = "上日余额", position = 22)
    private BigDecimal bal; // 上日余额

    @ApiModelProperty(value = "账户状态", position = 23)
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "子账户开户行", position = 24)
    private String openOrgNo; // 子账户开户行

    @ApiModelProperty(value = "开户日期", position = 25)
    private String startDt; // 开户日期

    @ApiModelProperty(value = "凭证号", position = 26)
    private String voucherNo; // 凭证号

    @ApiModelProperty(value = "活期子账户", position = 27)
    private String subAcctNo; // 活期子账户

    @ApiModelProperty(value = "当前余额", position = 28)
    private BigDecimal currentBal; // 当前余额

    // -----------------分割线---------------------------------------

}