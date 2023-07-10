package com.gientech.pcm.cust;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
/**
 * 客户实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_PCM_CUST")
public class PcmCust implements Serializable {
    private static final long serialVersionUID = 1L;
    @TableId(value = "CUST_ID", type = IdType.INPUT)
    private String custId;

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId;

    @TableField(value = "CUST_NAME")
    private String custName;

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId;

    @TableField(value = "LAW_ORG_NAME")
    private String lawOrgName;

    @TableField(value = "CUST_STATE")
    private String custState;

    @TableField(value = "CERT_TYPE")
    private String certType;

    @TableField(value = "CERT_NO")
    private String certNo;

    @TableField(value = "CERT_ADDR")
    private String certAddr;

    @TableField(value = "MOBILE")
    private String mobile;

    @TableField(value = "TEL")
    private String tel;

    @TableField(value = "ADDRESS")
    private String address;

    @TableField(value = "SEX")
    private String sex;

    @TableField(value = "MAR_STAT")
    private String marStat;

    @TableField(value = "BIRTHDAY")
    private String birthday;

    @TableField(value = "NATION")
    private String nation;

    @TableField(value = "COUNTRY")
    private String country;

    @TableField(value = "LIVING_TYPE")
    private String livingType;

    @TableField(value = "IS_OWN_CAR")
    private String isOwnCar;

    @TableField(value = "IS_OWN_HOUSE")
    private String isOwnHouse;

    @TableField(value = "HOME_INT_TOTAL")
    private String homeIntTotal;

    @TableField(value = "HIGHEST_EDU")
    private String highestEdu;

    @TableField(value = "HOBBY")
    private String hobby;

    @TableField(value = "TRADE")
    private String trade;

    @TableField(value = "PROFESSION")
    private String profession;

    @TableField(value = "POSITION")
    private String position;

    @TableField(value = "UNIT_NM")
    private String unitNm;

    @TableField(value = "IS_BLACKLIST")
    private String isBlacklist;

    @TableField(value = "BLACKLIST_SOURCE")
    private String blacklistSource;

    @TableField(value = "REMARK")
    private String remark;

    @TableField(value = "REMARK_USER")
    private String remarkUser;

    @TableField(value = "AGE")
    private Integer age;

    @TableField(value = "AGE_AREA")
    private String ageArea;

    @TableField(value = "AREA_NO")
    private String areaNo;

    @TableField(value = "IS_MERCHANT")
    private String isMerchant;

    @TableField(value = "IS_STOCK")
    private String isStock;

    @TableField(value = "UNIT_ADDR")
    private String unitAddr;

    @TableField(value = "UNIT_TEL")
    private String unitTel;

    @TableField(value = "IS_EMPLOYEE")
    private String isEmployee;
}
