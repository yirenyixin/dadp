package com.gientech.pmm.remindTemp;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cjm
 * @date 2023/7/7 21:50
 */
@Data
@TableName(value = "T_PMM_REMIND_TEMP")
public class PmmRemindTemp implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "REMIND_TEMP_ID")
    private String remindTempId;// 事件ID

    @TableField(value = "EVENT_TYPE")
    private String eventType;// 事件大类

    @TableField(value = "EVENT_SMALL_TYPE")
    private String eventSmallType;// 事件细类

    @TableField(value = "THRESHOLD_MON")
    private Integer thresholdMon;// 金额（元）

    @TableField(value = "DAY_NUM")
    private Integer dayNum;// 提前提醒天数/未维护间隔天数

    @TableField(value = "REMIND_ROLE_ID")
    private String remindRoleId;// 提醒角色

    @TableField(value = "IS_OK")
    private String isOk;// 状态

    @TableField(value = "VALID_DAY")
    private Integer validDay;// 有效天数

    @TableField(value = "MODIFY_USER_ID")
    private String modifyUserId;// 维护人

    @TableField(value = "MODIFY_TIME")
    private Date modifyTime;// 修改时间

    @TableField(value = "MODIFY_ORG_ID")
    private String modifyOrgId;// 维护人所在机构

}
