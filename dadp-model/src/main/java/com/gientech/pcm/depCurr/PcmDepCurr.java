package com.gientech.pcm.depCurr;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "T_PCM_DEP_CURR")
public class PcmDepCurr implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DEP_CURR_ID")
    private String depCurrId; // ID

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

    @TableField(value = "ACCT_NO")
    private String acctNo; // 账号/卡号

    @TableField(value = "CURR_NO")
    private String currNo; // 币种

    @TableField(value = "BAL")
    private Float bal; // 上日余额

    @TableField(value = "ACCT_STS")
    private String acctSts; // 账户状态

    @TableField(value = "OPEN_ORG_NO")
    private String openOrgNo; // 子账户开户行

    @TableField(value = "START_DT")
    private String startDt; // 开户日期

    @TableField(value = "VOUCHER_NO")
    private String voucherNo; // 凭证号

    @TableField(value = "SUB_ACCT_NO")
    private String subAcctNo; // 活期子账户

    @TableField(value = "CURRENT_BAL")
    private Float currentBal; // 当前余额

    // Getters and setters
}