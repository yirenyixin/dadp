package com.gientech.pmm.remindTemp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 0:23
 */
@Data
@ApiModel(value = "事件参数管理--删除DTO")
public class PmmRemindTempDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids,逗号分隔", required = true, position = 1)
    @NotBlank(message = "主键remindTempIds，不能为空")
    @Size(max = 400, message = "主键remindTempIds，的长度必须小于等于400")
    private String remindTempIds;// 主键ids,逗号分隔
}