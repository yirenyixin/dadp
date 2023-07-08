package com.gientech.pcm.prodOwn;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "T_PCM_PROD_OWN")
public class PcmProdOwn implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "PROD_OWN_ID")
    private String prodOwnId; // ID

    @TableField(value = "CUST_ID")
    private String custId; // 客户号

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId; // 法人机构号

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId; // ECIF客户号

    @TableField(value = "IS_DEP")
    private String isDep; // 是否持有活期

    @TableField(value = "IS_FIXED_DEP")
    private String isFixedDep; // 是否持有定期

    @TableField(value = "IS_LOAN")
    private String isLoan; // 是否持有贷款

    @TableField(value = "IS_WEALTH")
    private String isWealth; // 是否持有理财

    @TableField(value = "DEP_BAL")
    private Double depBal; // 活期余额

    @TableField(value = "FIXED_DEP_BAL")
    private Double fixedDepBal; // 定期余额

    @TableField(value = "LOAN_BAL")
    private Double loanBal; // 贷款余额

    @TableField(value = "WEALTH_BAL")
    private Double wealthBal; // 理财余额

    // 省略Getter和Setter方法
}
