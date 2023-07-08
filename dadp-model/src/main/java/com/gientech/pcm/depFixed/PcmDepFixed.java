package com.gientech.pcm.depFixed;//package com.example.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName(value = "T_PCM_DEP_FIXED")
public class PcmDepFixed implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "DEP_FIXED_ID", type = IdType.INPUT)
    private String depFixedId; // ID

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
    private String acctNo; // 账号

    @TableField(value = "SUB_ACCT_NO")
    private String subAcctNo; // 子账号

    @TableField(value = "ACCT_TYPE")
    private String acctType; // 存款类型

    @TableField(value = "FLOAT_RATE")
    private Float floatRate; // 浮动比率

    @TableField(value = "RATE")
    private Float rate; // 协议利率

    @TableField(value = "CURR_NO")
    private String currNo; // 币种

    @TableField(value = "BAL")
    private Float bal; // 上日余额

    @TableField(value = "TERM")
    private String term; // 存期

    @TableField(value = "END_DATE")
    private String endDate; // 到期日期

    @TableField(value = "ACCT_STS")
    private String acctSts; // 账户状态

    @TableField(value = "OPEN_ORG_NO")
    private String openOrgNo; // 开户机构号

    @TableField(value = "START_DT")
    private String startDt; // 起存日期

    @TableField(value = "VOUCHER_NO")
    private String voucherNo; // 凭证号

}