package com.gientech.pcm.loan;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "T_PCM_LOAN")
public class PcmLoan implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "LOAN_ID", type = IdType.INPUT)
    private String loanId; // ID

    @TableField(value = "CUST_ID")
    private String custId; // 客户ID

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId; // ECIF客户ID

    @TableField(value = "CUST_NAME")
    private String custName; // 客户名称

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId; // 法人机构号

    @TableField(value = "PROD_CODE")
    private String prodCode; // 产品代码

    @TableField(value = "PROD_NAME")
    private String prodName; // 产品名称

    @TableField(value = "LOAN_ACCT")
    private String loanAcct; // 贷款账号

    @TableField(value = "LOAN_ACCT_NAME")
    private String loanAcctName; // 账号名称

    @TableField(value = "LOAN_CONT_NO")
    private String loanContNo; // 合同编号

    @TableField(value = "VOUCHER_NO")
    private String voucherNo; // 借据号

    @TableField(value = "LOAN_MON")
    private Float loanMon; // 贷款金额

    @TableField(value = "GRANT_MON")
    private Float grantMon; // 发放金额

    @TableField(value = "LOAN_BAL")
    private Float loanBal; // 当前余额

    @TableField(value = "BAD_BAL")
    private Float badBal; // 不良余额

    @TableField(value = "LOAN_TYPE")
    private String loanType; // 贷款类型

    @TableField(value = "LOAN_STS")
    private String loanSts; // 贷款状态

    @TableField(value = "START_DATE")
    private String startDate; // 贷款发放日期

    @TableField(value = "END_DATE")
    private String endDate; // 贷款到期日期

    @TableField(value = "RATE")
    private Float rate; // 贷款利率

    @TableField(value = "LOAN_TERM")
    private Integer loanTerm; // 贷款期限（月）

    @TableField(value = "LOAN_CURRENCY")
    private String loanCurrency; // 贷款币种

    @TableField(value = "NEXT_REPAYMENT_MON")
    private Float nextRepaymentMon; // 下期还款金额（不含逾期）

    @TableField(value = "NEXT_REPAYMENT_DATE")
    private String nextRepaymentDate; // 下期还款日期

    @TableField(value = "LOAN_FIVE_FORM")
    private String loanFiveForm; // 五级分类标志

    @TableField(value = "OPEN_ORG_NO")
    private String openOrgNo; // 开户机构

    @TableField(value = "MGR_ID")
    private String mgrId; // 客户经理

    @TableField(value = "REPAY_ACCT")
    private String repayAcct; // 还款账号

    @TableField(value = "REPAY_NAME")
    private String repayName; // 账号名称

    @TableField(value = "LOAN_USE")
    private String loanUse; // 贷款用途

    // 省略Getter和Setter方法
}