package com.gientech.pmm.remindTemp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cjm
 * @date 2023/7/8 17:03
 */
@Data
@ApiModel("事件参数管理--查询条件的DTO类")
public class PmmRemindTempDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码，不能为空")
    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
    private Integer pageNo;// 当前页码

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小，不能为空")
    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
    private Integer pageSize;// 每页大小

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort;// 排序字段名,多个逗号分隔

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order;// 按什么排序(asc,desc)

    @JsonIgnore
    private String orderBy;// 排序sql片段

    // -----------------分割线---------------------------------------

    @ApiModelProperty(value = "事件ID", position = 5)
    private String remindTempId;// 事件ID

    @ApiModelProperty(value = "事件大类", position = 6)
    private String eventType;// 事件大类

    @ApiModelProperty(value = "事件细类", position = 7)
    private String eventSmallType;// 事件细类

    @ApiModelProperty(value = "金额（元）", position = 8)
    private Integer thresholdMon;// 金额（元）

    @ApiModelProperty(value = "提前提醒天数/未维护间隔天数", position = 9)
    private Integer dayNum;// 提前提醒天数/未维护间隔天数

    @ApiModelProperty(value = "提醒角色", position = 10)
    private String remindRoleId;// 提醒角色

    @ApiModelProperty(value = "状态", position = 11)
    private String isOk;// 状态

    @ApiModelProperty(value = "有效天数", position = 12)
    private Integer validDay;// 有效天数

    @ApiModelProperty(value = "维护人", position = 13)
    private String modifyUserId;// 维护人

    @ApiModelProperty(value = "修改时间", position = 14)
    private Date modifyTime;// 修改时间

    @ApiModelProperty(value = "维护人所在机构", position = 15)
    private String modifyOrgId;// 维护人所在机构
}