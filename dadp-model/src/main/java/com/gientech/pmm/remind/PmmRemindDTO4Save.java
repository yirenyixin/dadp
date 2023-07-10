package com.gientech.pmm.remind;

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
 * @date 2023/7/8 14:53
 */
@Data
@ApiModel(value = "提醒表--新增DTO")
public class PmmRemindDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty(value = "主键", required = true, position = 1)
//    @NotBlank(message = "主键，不能为空")
//    @Size(max = 32, message = "主键的长度必须小于等于32")
//    private String remindId; // 主键

    @ApiModelProperty(value = "提醒内容", required = true, position = 2)
    @NotBlank(message = "提醒内容，不能为空")
    @Size(max = 200, message = "提醒内容的长度必须小于等于200")
    private String remindContent; // 提醒内容

    @ApiModelProperty(value = "有效天数", required = true, position = 3)
    @NotNull(message = "有效天数，不能为空")
    //@Size(max = 4, message = "有效天数的长度必须小于等于4")
    private Integer validDay; // 有效天数

    @ApiModelProperty(value = "提醒日期", required = true, position = 4)
    //@NotBlank(message = "提醒日期，不能为空")
    private Date createDate; // 提醒日期

    @ApiModelProperty(value = "接收人", position = 5)
    @Size(max = 32, message = "接收人的长度必须小于等于32")
    private String receiverUserId; // 接收人

    @ApiModelProperty(value = "客户ID", position = 6)
    @Size(max = 32, message = "客户ID的长度必须小于等于32")
    private String custId; // 客户ID

    @ApiModelProperty(value = "客户归属法人机构", position = 7)
    @Size(max = 32, message = "客户归属法人机构的长度必须小于等于32")
    private String lawOrgId; // 客户归属法人机构

    @ApiModelProperty(value = "事件分类", position = 8)
    @Size(max = 32, message = "事件分类的长度必须小于等于32")
    private String eventType; // 事件分类

    @ApiModelProperty(value = "事件细类", position = 9)
    @Size(max = 32, message = "事件细类的长度必须小于等于32")
    private String eventSmallType; // 事件细类

}