package com.gientech.pmm.remindTemp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cjm
 * @date 2023/7/7 22:34
 */
@Data
public class PmmRemindTempVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "事件ID", position = 1)
    private String remindTempId;// 事件ID

    @ApiModelProperty(value = "事件大类", position = 2)
    private String eventType;// 事件大类

    @ApiModelProperty(value = "事件细类", position = 3)
    private String eventSmallType;// 事件细类

    @ApiModelProperty(value = "金额（元）", position = 4)
    private Integer thresholdMon;// 金额（元）

    @ApiModelProperty(value = "提前提醒天数/未维护间隔天数", position = 5)
    private Integer dayNum;// 提前提醒天数/未维护间隔天数

    @ApiModelProperty(value = "提醒角色", position = 6)
    private String remindRoleId;// 提醒角色

    @ApiModelProperty(value = "状态", position = 7)
    private String isOk;// 状态

    @ApiModelProperty(value = "有效天数", position = 8)
    private Integer validDay;// 有效天数

    @ApiModelProperty(value = "维护人", position = 9)
    private String modifyUserId;// 维护人

    @ApiModelProperty(value = "修改时间", position = 10)
    private Date modifyTime;// 修改时间

    @ApiModelProperty(value = "维护人所在机构", position = 11)
    private String modifyOrgId;// 维护人所在机构

}