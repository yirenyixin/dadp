package com.gientech.pcm.prodOwn;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("T_PCM_PROD_OWN")
public class PcmProdOwn {

    @TableField("PROD_OWN_ID")
    private String prodOwnId;

    @TableField("CUST_ID")
    private String custId;

    @TableField("LAW_ORG_ID")
    private String lawOrgId;

    @TableField("ECIF_CUST_ID")
    private String ecifCustId;

    @TableField("IS_DEP")
    private String isDep;

    @TableField("IS_FIXED_DEP")
    private String isFixedDep;

    @TableField("IS_LOAN")
    private String isLoan;

    @TableField("IS_WEALTH")
    private String isWealth;

    @TableField("DEP_BAL")
    private Double depBal;

    @TableField("FIXED_DEP_BAL")
    private Double fixedDepBal;

    @TableField("LOAN_BAL")
    private Double loanBal;

    @TableField("WEALTH_BAL")
    private Double wealthBal;



    // 省略Getter和Setter方法
}



