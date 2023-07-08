package com.gientech.pcm.prodOwn;

import java.io.Serializable;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "对私产品持有--更新DTO")
public class PcmProdOwnDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "PROD_OWN_ID", required = true)
    @NotBlank(message = "[prodOwnId] PROD_OWN_ID不能为空")
    @Size(max = 32, message = "PROD_OWN_ID的长度必须小于等于32")
    private String prodOwnId; // 产品持有ID

    @ApiModelProperty(value = "CUST_ID", required = true)
    @NotBlank(message = "[custId] CUST_ID不能为空")
    @Size(max = 32, message = "CUST_ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "LAW_ORG_ID", required = true)
    @NotBlank(message = "[lawOrgId] LAW_ORG_ID不能为空")
    @Size(max = 32, message = "LAW_ORG_ID的长度必须小于等于32")
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "ECIF_CUST_ID", required = true)
    @NotBlank(message = "[ecifCustId] ECIF_CUST_ID不能为空")
    @Size(max = 32, message = "ECIF_CUST_ID的长度必须小于等于32")
    private String ecifCustId; // ECIF客户ID

    @ApiModelProperty(value = "IS_DEP")
    @Size(max = 8, message = "IS_DEP的长度必须小于等于8")
    private String isDep; // 是否持有活期

    @ApiModelProperty(value = "IS_FIXED_DEP")
    @Size(max = 8, message = "IS_FIXED_DEP的长度必须小于等于8")
    private String isFixedDep; // 是否持有定期

    @ApiModelProperty(value = "IS_LOAN")
    @Size(max = 8, message = "IS_LOAN的长度必须小于等于8")
    private String isLoan; // 是否持有贷款

    @ApiModelProperty(value = "IS_WEALTH")
    @Size(max = 8, message = "IS_WEALTH的长度必须小于等于8")
    private String isWealth; // 是否持有理财

    @ApiModelProperty(value = "DEP_BAL")
    @DecimalMin(value = "0", message = "[depBal] DEP_BAL不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[depBal] DEP_BAL不能大于99999999999999999999.99")
    private Double depBal; // 活期余额

    @ApiModelProperty(value = "FIXED_DEP_BAL")
    @DecimalMin(value = "0", message = "[fixedDepBal] FIXED_DEP_BAL不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[fixedDepBal] FIXED_DEP_BAL不能大于99999999999999999999.99")
    private Double fixedDepBal; // 定期余额

    @ApiModelProperty(value = "LOAN_BAL")
    @DecimalMin(value = "0", message = "[loanBal] LOAN_BAL不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[loanBal] LOAN_BAL不能大于99999999999999999999.99")
    private Double loanBal; // 贷款余额

    @ApiModelProperty(value = "WEALTH_BAL")
    @DecimalMin(value = "0", message = "[wealthBal] WEALTH_BAL不能小于0")
    @DecimalMax(value = "99999999999999999999.99", message = "[wealthBal] WEALTH_BAL不能大于99999999999999999999.99")
    private Double wealthBal; // 理财余额

    // Getters and setters
}