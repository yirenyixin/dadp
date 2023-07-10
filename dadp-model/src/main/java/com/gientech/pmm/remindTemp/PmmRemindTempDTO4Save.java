package com.gientech.pmm.remindTemp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * @author cjm
 * @date 2023/7/7 22:45
 */
@Data
@ApiModel(value = "时间参数管理--新增DTO")
public class PmmRemindTempDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "事件ID", required = true, position = 1)
//    @NotBlank(message = "事件ID，不能为空")
//    @Size(max = 32, message = "事件ID的长度必须小于等于32")
//    private String remindTempId;// 事件ID

    @ApiModelProperty(value = "事件大类", required = true, position = 2)
    @NotBlank(message = "事件大类，不能为空")
    @Size(max = 32, message = "事件大类的长度必须小于等于32")
    private String eventType;// 事件大类

    @ApiModelProperty(value = "事件细类", required = true, position = 3)
    @NotBlank(message = "事件细类，不能为空")
    @Size(max = 32, message = "事件细类的长度必须小于等于32")
    private String eventSmallType;// 事件细类

    @ApiModelProperty(value = "金额（元）", position = 4)
    //@Size(max = 10, message = "金额（元）的长度必须小于等于10")
    private Integer thresholdMon;// 金额（元）

    @ApiModelProperty(value = "提前提醒天数/未维护间隔天数", position = 5)
    //@Size(max = 5, message = "提前提醒天数/未维护间隔天数的长度必须小于等于5")
    private Integer dayNum;// 提前提醒天数/未维护间隔天数

    @ApiModelProperty(value = "提醒角色", required = true, position = 6)
    @NotBlank(message = "提醒角色，不能为空")
    @Size(max = 32, message = "提醒角色的长度必须小于等于32")
    private String remindRoleId;// 提醒角色

    @ApiModelProperty(value = "状态", required = true, position = 7)
    @NotBlank(message = "状态，不能为空")
    @Size(max = 32, message = "状态的长度必须小于等于32")
    private String isOk;// 状态

    @ApiModelProperty(value = "有效天数", required = true, position = 8)
    @NotNull(message = "有效天数，不能为空")
    //@Size(max = 4, message = "有效天数的长度必须小于等于4")
    private Integer validDay;// 有效天数

    @ApiModelProperty(value = "维护人", position = 9)
    @Size(max = 32, message = "维护人的长度必须小于等于32")
    private String modifyUserId;// 维护人

    @ApiModelProperty(value = "修改时间", position = 10)
    private Date modifyTime;// 修改时间

    @ApiModelProperty(value = "维护人所在机构", position = 11)
    @Size(max = 32, message = "维护人所在机构的长度必须小于等于32")
    private String modifyOrgId;// 维护人所在机构

}