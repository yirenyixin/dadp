package com.gientech.pmm.remind;

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
 * @date 2023/7/8 15:43
 */
@Data
@ApiModel("提醒表--查询条件的DTO类")
public class PmmRemindDTO4List implements Serializable {

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
    @ApiModelProperty(value = "主键", position = 5)
    private String remindId; // 主键

    @ApiModelProperty(value = "提醒内容", position = 6)
    private String remindContent; // 提醒内容

    @ApiModelProperty(value = "有效天数", position = 7)
    private Integer validDay; // 有效天数

    @ApiModelProperty(value = "提醒日期", position = 8)
    private Date createDate; // 提醒日期

    @ApiModelProperty(value = "接收人", position = 9)
    private String receiverUserId; // 接收人

    @ApiModelProperty(value = "客户ID", position = 10)
    private String custId; // 客户ID

    @ApiModelProperty(value = "客户归属法人机构", position = 11)
    private String lawOrgId; // 客户归属法人机构

    @ApiModelProperty(value = "事件分类", position = 12)
    private String eventType; // 事件分类

    @ApiModelProperty(value = "事件细类", position = 13)
    private String eventSmallType; // 事件细类
}