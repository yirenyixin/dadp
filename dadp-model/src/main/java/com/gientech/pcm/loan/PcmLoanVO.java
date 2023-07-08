package com.gientech.pcm.loan;

import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PcmLoanVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "贷款ID", position = 1)
    private String loanId;

    @ApiModelProperty(value = "客户ID", position = 2)
    private String custId;

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

    @ApiModelProperty(value = "贷款账号", position = 8)
    private String loanAcct;

    @ApiModelProperty(value = "贷款账户名称", position = 9)
    private String loanAcctName;

    @ApiModelProperty(value = "贷款合同号", position = 10)
    private String loanContNo;

    @ApiModelProperty(value = "凭证号", position = 11)
    private String voucherNo;

    @ApiModelProperty(value = "贷款金额", position = 12)
    private Double loanMon;

    @ApiModelProperty(value = "发放金额", position = 13)
    private Double grantMon;

    @ApiModelProperty(value = "贷款余额", position = 14)
    private Double loanBal;

    @ApiModelProperty(value = "不良余额", position = 15)
    private Double badBal;

    @ApiModelProperty(value = "贷款类型", position = 16)
    private String loanType;

    @ApiModelProperty(value = "贷款状态", position = 17)
    private String loanSts;

    @ApiModelProperty(value = "起始日期", position = 18)
    private String startDate;

    @ApiModelProperty(value = "到期日期", position = 19)
    private String endDate;

    @ApiModelProperty(value = "利率", position = 20)
    private Double rate;

    @ApiModelProperty(value = "贷款期限", position = 21)
    private Integer loanTerm;

    @ApiModelProperty(value = "贷款币种", position = 22)
    private String loanCurrency;

    @ApiModelProperty(value = "下次还款金额", position = 23)
    private Double nextRepaymentMon;

    @ApiModelProperty(value = "下次还款日期", position = 24)
    private String nextRepaymentDate;

    @ApiModelProperty(value = "贷款五级分类", position = 25)
    private String loanFiveForm;

    @ApiModelProperty(value = "开户机构号", position = 26)
    private String openOrgNo;

    @ApiModelProperty(value = "管理员ID", position = 27)
    private String mgrId;

    @ApiModelProperty(value = "还款账号", position = 28)
    private String repayAcct;

    @ApiModelProperty(value = "还款账户名称", position = 29)
    private String repayName;

    @ApiModelProperty(value = "贷款用途", position = 30)
    private String loanUse;

    // Getters and setters
}