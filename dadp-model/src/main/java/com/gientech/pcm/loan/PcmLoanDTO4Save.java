package com.gientech.pcm.loan;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@ApiModel(value = "贷款--更新DTO")
public class PcmLoanDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "LOAN_ID", required = true, position = 1)
    @NotBlank(message = "[loanId] LOAN_ID不能为空")
    @Size(max = 32, message = "LOAN_ID的长度必须小于等于32")
    private String loanId; // 贷款ID

    @ApiModelProperty(value = "CUST_ID", required = true, position = 2)
    @NotBlank(message = "[custId] CUST_ID不能为空")
    @Size(max = 32, message = "CUST_ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "ECIF_CUST_ID", required = true, position = 3)
//    @NotBlank(message = "[ecifCustId] ECIF_CUST_ID不能为空")
    @Size(max = 32, message = "ECIF_CUST_ID的长度必须小于等于32")
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "CUST_NAME", required = true, position = 4)
//    @NotBlank(message = "[custName] 客户名称不能为空")
    @Size(max = 128, message = "客户名称的长度必须小于等于128")
    private String custName; // 客户名称

    @ApiModelProperty(value = "LAW_ORG_ID", required = true, position = 5)
//    @NotBlank(message = "[lawOrgId] 法人机构号不能为空")
    @Size(max = 32, message = "法人机构号的长度必须小于等于32")
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "PROD_CODE", required = true, position = 6)
//    @NotBlank(message = "[prodCode] 产品代码不能为空")
    @Size(max = 32, message = "产品代码的长度必须小于等于32")
    private String prodCode; // 产品代码

    @ApiModelProperty(value = "PROD_NAME", required = true, position = 7)
//    @NotBlank(message = "[prodName] 产品名称不能为空")
    @Size(max = 100, message = "产品名称的长度必须小于等于100")
    private String prodName; // 产品名称

    @ApiModelProperty(value = "LOAN_ACCT", required = true, position = 8)
//    @NotBlank(message = "[loanAcct] 贷款账号不能为空")
    @Size(max = 32, message = "贷款账号的长度必须小于等于32")
    private String loanAcct; // 贷款账号

    @ApiModelProperty(value = "LOAN_ACCT_NAME", required = true, position = 9)
//    @NotBlank(message = "[loanAcctName] 贷款账户名称不能为空")
    @Size(max = 128, message = "贷款账户名称的长度必须小于等于128")
    private String loanAcctName; // 贷款账户名称

    @ApiModelProperty(value = "LOAN_CONT_NO", required = true, position = 10)
//    @NotBlank(message = "[loanContNo] 贷款合同号不能为空")
    @Size(max = 32, message = "贷款合同号的长度必须小于等于32")
    private String loanContNo; // 贷款合同号

    @ApiModelProperty(value = "VOUCHER_NO", required = true, position = 11)
//    @NotBlank(message = "[voucherNo] 凭证号不能为空")
    @Size(max = 32, message = "凭证号的长度必须小于等于32")
    private String voucherNo; // 凭证号

    @ApiModelProperty(value = "LOAN_MON", position = 12)
    @DecimalMin(value = "0", message = "[loanMon] 贷款金额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[loanMon] 贷款金额不能大于99999999999999999999.99")
    private Double loanMon; // 贷款金额

    @ApiModelProperty(value = "GRANT_MON", position = 13)
    @DecimalMin(value = "0", message = "[grantMon] 发放金额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[grantMon] 发放金额不能大于99999999999999999999.99")
    private Double grantMon; // 发放金额

    @ApiModelProperty(value = "LOAN_BAL", position = 14)
    @DecimalMin(value = "0", message = "[loanBal] 贷款余额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[loanBal] 贷款余额不能大于99999999999999999999.99")
    private Double loanBal; // 贷款余额

    @ApiModelProperty(value = "BAD_BAL", position = 15)
    @DecimalMin(value = "0", message = "[badBal] 不良余额不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[badBal] 不良余额不能大于99999999999999999999.99")
    private Double badBal; // 不良余额


    @ApiModelProperty(value = "LOAN_TYPE", required = true, position = 16)
//    @NotBlank(message = "[loanType] 贷款类型不能为空")
    @Size(max = 32, message = "贷款类型的长度必须小于等于32")
    private String loanType; // 贷款类型

    @ApiModelProperty(value = "LOAN_STS", required = true, position = 17)
//    @NotBlank(message = "[loanSts] 贷款状态不能为空")
    @Size(max = 32, message = "贷款状态的长度必须小于等于32")
    private String loanSts; // 贷款状态

    @ApiModelProperty(value = "START_DATE", required = true, position = 18)
//    @NotBlank(message = "[startDate] 起始日期不能为空")
    @Size(max = 10, message = "起始日期的长度必须小于等于10")
    private String startDate; // 起始日期

    @ApiModelProperty(value = "END_DATE", required = true, position = 19)
//    @NotBlank(message = "[endDate] 到期日期不能为空")
    @Size(max = 10, message = "到期日期的长度必须小于等于10")
    private String endDate; // 到期日期

    @ApiModelProperty(value = "RATE", position = 20)
    @DecimalMin(value = "0", message = "[rate] 利率不能小于0")
    @DecimalMax(value = "999999.999999", message = "[rate] 利率不能大于999999.999999")
    private Double rate; // 利率

    @ApiModelProperty(value = "LOAN_TERM", required = true, position = 21)
    @DecimalMin(value = "0", message = "[loanTerm] 贷款期限不能小于0")
    @DecimalMax(value = "9999", message = "[loanTerm] 贷款期限不能大于9999")
    private Integer loanTerm; // 贷款期限

    @ApiModelProperty(value = "LOAN_CURRENCY", required = true, position = 22)
//    @NotBlank(message = "[loanCurrency] 贷款币种不能为空")
    @Size(max = 32, message = "贷款币种的长度必须小于等于32")
    private String loanCurrency; //贷款币种

    @ApiModelProperty(value = "NEXT_REPAYMENT_MON", position = 23)
    private Double nextRepaymentMon; // 下次还款金额

    @ApiModelProperty(value = "NEXT_REPAYMENT_DATE", position = 24)
//    @NotBlank(message = "[nextRepaymentDate] 下次还款日期不能为空")
    @Size(max = 10, message = "下次还款日期的长度必须小于等于10")
    private String nextRepaymentDate; // 下次还款日期

    @ApiModelProperty(value = "LOAN_FIVE_FORM", position = 25)
//    @NotBlank(message = "[loanFiveForm] 贷款五级分类不能为空")
    @Size(max = 32, message = "贷款五级分类的长度必须小于等于32")
    private String loanFiveForm; // 贷款五级分类

    @ApiModelProperty(value = "OPEN_ORG_NO", required = true, position = 26)
//    @NotBlank(message = "[openOrgNo] 开户机构号不能为空")
    @Size(max = 32, message = "开户机构号的长度必须小于等于32")
    private String openOrgNo; // 开户机构号

    @ApiModelProperty(value = "MGR_ID", required = true, position = 27)
//    @NotBlank(message = "[mgrId] 管理员ID不能为空")
    @Size(max = 32, message = "管理员ID的长度必须小于等于32")
    private String mgrId; // 管理员ID

    @ApiModelProperty(value = "REPAY_ACCT", required = true, position = 28)
//    @NotBlank(message = "[repayAcct] 还款账号不能为空")
    @Size(max = 32, message = "还款账号的长度必须小于等于32")
    private String repayAcct; // 还款账号

    @ApiModelProperty(value = "REPAY_NAME", required = true, position = 29)
//    @NotBlank(message = "[repayName] 还款账户名称不能为空")
    @Size(max = 128, message = "还款账户名称的长度必须小于等于128")
    private String repayName; // 还款账户名称

    @ApiModelProperty(value = "LOAN_USE", position = 30)
    @Size(max = 200, message = "贷款用途的长度必须小于等于200")
    private String loanUse; // 贷款用途

    // Getters and setters
}