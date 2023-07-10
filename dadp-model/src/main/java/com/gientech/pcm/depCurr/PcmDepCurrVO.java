package com.gientech.pcm.depCurr;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PcmDepCurrVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ID", position = 1)
    private String custId;

    @ApiModelProperty(value = "ID", position = 2)
    private String depCurrId;

    @ApiModelProperty(value = "ECIF客户ID", position = 3)
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", position = 4)
    private String custName;

    @ApiModelProperty(value = "法人机构号", position = 5)
    private String lawOrgId;

    @ApiModelProperty(value = "产品代码", position = 6)
    private String prodCode;

    @ApiModelProperty(value = "产品名称", position = 7)
    private String prodName;

    @ApiModelProperty(value = "账号/卡号", position = 8)
    private String acctNo;

    @ApiModelProperty(value = "币种", position = 9)
    private String currNo;

    @ApiModelProperty(value = "上日余额", position = 10)
    private Double bal;

    @ApiModelProperty(value = "账户状态", position = 11)
    private String acctSts;

    @ApiModelProperty(value = "子账户开户行", position = 12)
    private String openOrgNo;

    @ApiModelProperty(value = "开户日期", position = 13)
    private String startDt;

    @ApiModelProperty(value = "凭证号", position = 14)
    private String voucherNo;

    @ApiModelProperty(value = "活期子账户", position = 15)
    private String subAcctNo;

    @ApiModelProperty(value = "当前余额", position = 16)
    private Double currentBal;

    // Getters and setters
}