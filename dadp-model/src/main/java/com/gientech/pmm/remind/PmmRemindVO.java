package com.gientech.pmm.remind;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cjm
 * @date 2023/7/8 14:50
 */
@Data
public class PmmRemindVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", position = 1)
    private String remindId; // 主键

    @ApiModelProperty(value = "提醒内容", position = 2)
    private String remindContent; // 提醒内容

    @ApiModelProperty(value = "有效天数", position = 3)
    private Integer validDay; // 有效天数

    @ApiModelProperty(value = "提醒日期", position = 4)
    private Date createDate; // 提醒日期

    @ApiModelProperty(value = "接收人", position = 5)
    private String receiverUserId; // 接收人

    @ApiModelProperty(value = "客户ID", position = 6)
    private String custId; // 客户ID

    @ApiModelProperty(value = "客户归属法人机构", position = 7)
    private String lawOrgId; // 客户归属法人机构

    @ApiModelProperty(value = "事件分类", position = 8)
    private String eventType; // 事件分类

    @ApiModelProperty(value = "事件细类", position = 9)
    private String eventSmallType; // 事件细类

}