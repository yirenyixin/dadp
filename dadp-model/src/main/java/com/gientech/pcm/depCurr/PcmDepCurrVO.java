package com.gientech.pcm.depCurr;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PcmDepCurrVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "DEP_CURR_ID", position = 1)
    private String depCurrId; // ID

    @ApiModelProperty(value = "CUST_ID", position = 2)
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF_CUST_ID", position = 3)
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "CUST_NAME", position = 4)
    private String custName; // 客户名称

    @ApiModelProperty(value = "LAW_ORG_ID", position = 5)
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "PROD_CODE", position = 6)
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "PROD_NAME", position = 7)
    private String prodName; // 产品名称

    @ApiModelProperty(value = "ACCT_NO", position = 8)
    private String acctNo; // 账号

    @ApiModelProperty(value = "CURR_NO", position = 9)
    private String currNo; // 币种

    @ApiModelProperty(value = "BAL", position = 10)
    private Float bal; // 上日余额

    @ApiModelProperty(value = "ACCT_STS", position = 11)
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "OPEN_ORG_NO", position = 12)
    private String openOrgNo; // 开户机构号

    @ApiModelProperty(value = "START_DT", position = 13)
    private String startDt; // 起存日期

    @ApiModelProperty(value = "VOUCHER_NO", position = 14)
    private String voucherNo; // 凭证号

    @ApiModelProperty(value = "SUB_ACCT_NO", position = 15)
    private String subAcctNo; // 子账号

    @ApiModelProperty(value = "CURRENT_BAL", position = 16)
    private Float currentBal; // 当前余额

    // Getters and setters
}