package com.gientech.pcm.wealth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cjm
 * @date 2023/7/7 17:01
 */
@Data
public class PcmWealthVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID", position = 1)
    private String wealthId;

    @ApiModelProperty(value = "客户ID", position = 2)
    private String custId;

    @ApiModelProperty(value = "ECIF客户ID", position = 3)
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", position = 4)
    private String custName;

    @ApiModelProperty(value = "法人机构号", position = 5)
    private String lawOrgId;

    @ApiModelProperty(value = "开户机构号", position = 6)
    private String openOrgId;

    @ApiModelProperty(value = "产品代码", position = 7)
    private String prodCode;

    @ApiModelProperty(value = "产品名称", position = 8)
    private String prodName;

    @ApiModelProperty(value = "产品类型", position = 9)
    private String prodType;

    @ApiModelProperty(value = "风险等级", position = 10)
    private String riskLevel;

    @ApiModelProperty(value = "发行方", position = 11)
    private String publicOrg;

    @ApiModelProperty(value = "业绩比较基准", position = 12)
    private BigDecimal perfCompareBase;

    @ApiModelProperty(value = "当前余额", position = 13)
    private BigDecimal currentBal;

    @ApiModelProperty(value = "起息日期", position = 14)
    private String interestDate;

    @ApiModelProperty(value = "产品到期日", position = 15)
    private String endDate;

    @ApiModelProperty(value = "持有收益", position = 16)
    private BigDecimal holdProfit;

    @ApiModelProperty(value = "持有收益率", position = 17)
    private BigDecimal holdProfitRate;
}