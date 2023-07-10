package com.gientech.pcm.orgRel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 机构归属关系实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_PCM_ORG_REL")
public class PcmOrgRel implements Serializable {
    @TableId(value = "ORG_REL_ID", type = IdType.INPUT)
    private String orgRelId;

    @TableField(value = "CUST_ID")
    private String custId;

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId;

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId;

    @TableField(value = "CUST_NAME")
    private String custName;

    @TableField(value = "BELONG_ORG_ID")
    private String belongOrgId;

    @TableField(value = "BELONG_ORG_NAME")
    private String belongOrgName;

    @TableField(value = "MAIN_ORG_TYPE")
    private String mainOrgType;

    @TableField(value = "ASSIGN_TYPE")
    private String assignType;

    @TableField(value = "ASSIGN_USER_ID")
    private String assignUserId;

    @TableField(value = "ASSIGN_DATE")
    private Date assignDate;
}
