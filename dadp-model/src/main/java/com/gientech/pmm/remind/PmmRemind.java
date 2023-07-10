package com.gientech.pmm.remind;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户实体类，和数据库完全对应
 */
@Data
@TableName(value = "T_PMM_REMIND")
public class PmmRemind implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REMIND_ID")
    private String remindId; // 主键

    @TableField(value = "REMIND_CONTENT")
    private String remindContent; // 提醒内容

    @TableField(value = "VALID_DAY")
    private Integer validDay; // 有效天数

    @TableField(value = "CREATE_DATE")
    private Date createDate; // 提醒日期

    @TableField(value = "RECEIVER_USER_ID")
    private String receiverUserId; // 接收人

    @TableField(value = "CUST_ID")
    private String custId; // 客户ID

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId; // 客户归属法人机构

    @TableField(value = "EVENT_TYPE")
    private String eventType; // 事件分类

    @TableField(value = "EVENT_SMALL_TYPE")
    private String eventSmallType; // 事件细类

}