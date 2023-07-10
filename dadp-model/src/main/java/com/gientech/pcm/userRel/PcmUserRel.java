package com.gientech.pcm.userRel;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
/**
 * 客户经理归属关系实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_PCM_USER_REL")
public class PcmUserRel implements Serializable {
    @TableId(value = "USER_REL_ID", type = IdType.INPUT)
    private String userRelId;

    @TableField(value = "CUST_ID")
    private String custId;

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId;

    @TableField(value = "ECIF_CUST_ID")
    private String ecifCustId;

    @TableField(value = "CUST_NAME")
    private String custName;

    @TableField(value = "BELONG_MGR_ID")
    private String belongMgrId;

    @TableField(value = "BELONG_MGR_NAME")
    private String belongMgrName;

    @TableField(value = "MAIN_MGR_TYPE")
    private String mainMgrType;

    @TableField(value = "ASSIGN_TYPE")
    private String assignType;

    @TableField(value = "BEGIN_DATE")
    private Date beginDate;

    @TableField(value = "END_DATE")
    private Date endDate;

    @TableField(value = "ASSIGN_USER_ID")
    private String assignUserId;

    @TableField(value = "ASSIGN_DATE")
    private Date assignDate;
}
