package com.gientech.pcm.loan;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@ApiModel(value = "对私贷款--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" }) // 字段不接受前台传参，防止sql注入
public class PcmLoanDTO4List implements Serializable {

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
    private String loanId; // ID

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

    @ApiModelProperty(value = "贷款账号", position = 20)
    private String loanAcct; // 贷款账号

    @ApiModelProperty(value = "账号名称", position = 21)
    private String loanAcctName; // 账号名称

    @ApiModelProperty(value = "合同编号", position = 22)
    private String loanContNo; // 合同编号

    @ApiModelProperty(value = "借据号", position = 23)
    private String voucherNo; // 借据号

    @ApiModelProperty(value = "贷款金额", position = 24)
    private Double loanMon; // 贷款金额

    @ApiModelProperty(value = "发放金额", position = 25)
    private Double grantMon; // 发放金额

    @ApiModelProperty(value = "当前余额", position = 26)
    private Double loanBal; // 当前余额

    @ApiModelProperty(value = "不良余额", position = 27)
    private Double badBal; // 不良余额

    @ApiModelProperty(value = "贷款类型", position = 28)
    private String loanType; // 贷款类型

    @ApiModelProperty(value = "贷款状态", position = 29)
    private String loanSts; // 贷款状态

    @ApiModelProperty(value = "贷款发放日期", position = 30)
    private String startDate; // 贷款发放日期

    @ApiModelProperty(value = "贷款到期日期", position = 31)
    private String endDate; // 贷款到期日期

    @ApiModelProperty(value = "贷款利率", position = 32)
    private Double rate; // 贷款利率

    @ApiModelProperty(value = "贷款期限（月）", position = 33)
    private Integer loanTerm; // 贷款期限（月）

    @ApiModelProperty(value = "贷款币种", position = 34)
    private String loanCurrency; // 贷款币种

    @ApiModelProperty(value = "下期还款金额（不含逾期）", position = 35)
    private Double nextRepaymentMon; // 下期还款金额（不含逾期）

    @ApiModelProperty(value = "下期还款日期", position = 36)
    private String nextRepaymentDate; // 下期还款日期

    @ApiModelProperty(value = "五级分类标志", position = 37)
    private String loanFiveForm; // 五级分类标志

    @ApiModelProperty(value = "开户机构", position = 38)
    private String openOrgNo; // 开户机构

    @ApiModelProperty(value = "客户经理", position = 39)
    private String mgrId; // 客户经理

    @ApiModelProperty(value = "还款账号", position = 40)
    private String repayAcct; // 还款账号

    @ApiModelProperty(value = "账号名称", position = 41)
    private String repayName; // 账号名称

    @ApiModelProperty(value = "贷款用途", position = 42)
    private String loanUse; // 贷款用途

    // -----------------分割线---------------------------------------



    @ApiModelProperty(value = "持有类型", position = 43)
    private String isHis; // 是否历史持有  0当前  1 历史

    @ApiModelProperty(value = "当前日期", position = 44)
    private String nowDate;

}