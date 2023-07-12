package com.gientech.pcm.prodOwn;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "持有产品表--保存DTO")
public class PcmProdOwnDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "PROD_OWN_ID", required = true, position = 1)
    @NotBlank(message = "[prodOwnId] PROD_OWN_ID不能为空")
    @Size(max = 32, message = "PROD_OWN_ID的长度必须小于等于32")
    private String prodOwnId; // 持有产品编号

    @ApiModelProperty(value = "CUST_ID", required = true, position = 2)
//    @NotBlank(message = "[custId] 客户号不能为空")
    @Size(max = 32, message = "客户号的长度必须小于等于32")
    private String custId; // 客户号

    @ApiModelProperty(value = "LAW_ORG_ID", required = true, position = 3)
//    @NotBlank(message = "[lawOrgId] 法人机构号不能为空")
    @Size(max = 32, message = "法人机构号的长度必须小于等于32")
    private String lawOrgId; // 法人机构号

    @ApiModelProperty(value = "ECIF_CUST_ID", required = true, position = 4)
//    @NotBlank(message = "[ecifCustId] ECIF客户号不能为空")
    @Size(max = 32, message = "ECIF客户号的长度必须小于等于32")
    private String ecifCustId; // ECIF客户号

    @ApiModelProperty(value = "IS_DEP", position = 5)
    @Size(max = 8, message = "是否持有活期的长度必须小于等于8")
    private String isDep; // 是否持有活期

    @ApiModelProperty(value = "IS_FIXED_DEP", position = 6)
    @Size(max = 8, message = "是否持有定期的长度必须小于等于8")
    private String isFixedDep; // 是否持有定期

    @ApiModelProperty(value = "IS_LOAN", position = 7)
    @Size(max = 8, message = "是否持有贷款的长度必须小于等于8")
    private String isLoan; // 是否持有贷款

    @ApiModelProperty(value = "IS_WEALTH", position = 8)
    @Size(max = 8, message = "是否持有理财的长度必须小于等于8")
    private String isWealth; // 是否持有理财

    @ApiModelProperty(value = "DEP_BAL", position = 9)
    @DecimalMin(value = "0", inclusive = false, message = "活期余额必须大于0")
    @DecimalMax(value = "9999999999.999999", message = "活期余额的最大值为9999999999.999999")
    private BigDecimal depBal; // 活期余额

    @ApiModelProperty(value = "FIXED_DEP_BAL", position = 10)
    @DecimalMin(value = "0", inclusive = false, message = "定期余额必须大于0")
    @DecimalMax(value = "9999999999.999999", message = "定期余额的最大值为9999999999.999999")
    private BigDecimal fixedDepBal; // 定期余额

    @ApiModelProperty(value = "LOAN_BAL", position = 11)
    @DecimalMin(value = "0", inclusive = false, message = "贷款余额必须大于0")
    @DecimalMax(value = "9999999999.999999", message = "贷款余额的最大值为9999999999.999999")
    private BigDecimal loanBal; // 贷款余额

    @ApiModelProperty(value = "WEALTH_BAL", position = 12)
    @DecimalMin(value = "0", inclusive = false, message = "理财余额必须大于0")
    @DecimalMax(value = "9999999999.999999", message = "理财余额的最大值为9999999999.999999")
    private BigDecimal wealthBal; // 理财余额

    // Getters and setters
}