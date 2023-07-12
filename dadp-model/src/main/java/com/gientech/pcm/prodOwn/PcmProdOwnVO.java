package com.gientech.pcm.prodOwn;
import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PcmProdOwnVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "持有产品编号", position = 1)
    private String prodOwnId;

    @ApiModelProperty(value = "客户号", position = 2)
    private String custId;

    @ApiModelProperty(value = "法人机构号", position = 3)
    private String lawOrgId;

    @ApiModelProperty(value = "ECIF客户号", position = 4)
    private String ecifCustId;

    @ApiModelProperty(value = "是否持有活期", position = 5)
    private String isDep;

    @ApiModelProperty(value = "是否持有定期", position = 6)
    private String isFixedDep;

    @ApiModelProperty(value = "是否持有贷款", position = 7)
    private String isLoan;

    @ApiModelProperty(value = "是否持有理财", position = 8)
    private String isWealth;

    @ApiModelProperty(value = "活期余额", position = 9)
    private BigDecimal depBal;

    @ApiModelProperty(value = "定期余额", position = 10)
    private BigDecimal fixedDepBal;

    @ApiModelProperty(value = "贷款余额", position = 11)
    private BigDecimal loanBal;

    @ApiModelProperty(value = "理财余额", position = 12)
    private BigDecimal wealthBal;

    // Getters and setters
}