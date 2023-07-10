package com.gientech.pcm.wealth;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author cjm
 * @date 2023/7/7 16:29
 */
@Data
@TableName(value = "T_PCM_WEALTH")
public class PcmWealth implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "WEALTH_ID", type = IdType.ASSIGN_UUID)
    private String wealthId; //ID

    @TableField(value = "CUST_ID")
    private String custId; //客户ID

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId; //ECIF客户ID

    @TableField(value = "CUST_NAME")
    private String custName; //客户名称

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId; //法人机构号

    @TableField(value = "OPEN_ORG_ID")
    private String openOrgId; //开户机构号

    @TableField(value = "PROD_CODE")
    private String prodCode; //产品代码

    @TableField(value = "PROD_NAME")
    private String prodName; //产品名称

    @TableField(value = "PROD_TYPE")
    private String prodType; //产品类型

    @TableField(value = "RISK_LEVEL")
    private String riskLevel; //风险等级

    @TableField(value = "PUBLIC_ORG")
    private String publicOrg; //发行方

    @TableField(value = "PERF_COMPARE_BASE")
    private BigDecimal perfCompareBase; //业绩比较基准

    @TableField(value = "CURRENT_BAL")
    private BigDecimal currentBal; //当前余额

    @TableField(value = "INTEREST_DATE")
    private String interestDate; //起息日期

    @TableField(value = "END_DATE")
    private String endDate; //产品到期日

    @TableField(value = "HOLD_PROFIT")
    private BigDecimal holdProfit; //持有收益

    @TableField(value = "HOLD_PROFIT_RATE")
    private BigDecimal holdProfitRate; //持有收益率



}