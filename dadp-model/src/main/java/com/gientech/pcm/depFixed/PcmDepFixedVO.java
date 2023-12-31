package com.gientech.pcm.depFixed;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class PcmDepFixedVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "DEP_FIXED_ID", position = 1)
    private String depFixedId; // ID

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

    @ApiModelProperty(value = "SUB_ACCT_NO", position = 9)
    private String subAcctNo; // 子账号

    @ApiModelProperty(value = "ACCT_TYPE", position = 10)
    private String acctType; // 存款类型

    @ApiModelProperty(value = "FLOAT_RATE", position = 11)
    private Float floatRate; // 浮动比率

    @ApiModelProperty(value = "RATE", position = 12)
    private Float rate; // 协议利率

    @ApiModelProperty(value = "CURR_NO", position = 13)
    private String currNo; // 币种

    @ApiModelProperty(value = "BAL", position = 14)
    private Float bal; // 上日余额

    @ApiModelProperty(value = "TERM", position = 15)
    private String term; // 存期

    @ApiModelProperty(value = "END_DATE", position = 16)
    private String endDate; // 到期日期

    @ApiModelProperty(value = "ACCT_STS", position = 17)
    private String acctSts; // 账户状态

    @ApiModelProperty(value = "OPEN_ORG_NO", position = 18)
    private String openOrgNo; // 开户机构号

    @ApiModelProperty(value = "START_DT", position = 19)
    private String startDt; // 起存日期

    @ApiModelProperty(value = "VOUCHER_NO", position = 20)
    private String voucherNo; // 凭证号

    // Getters and setters
}