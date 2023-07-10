package com.gientech.pmm.remind;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 15:21
 */
@Data
@ApiModel(value = "提醒表--删除")
public class PmmRemindDTO4Delete implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids，逗号分隔", required = true, position = 1)
    @NotBlank(message = "主键ids，不能为空")
    @Size(max = 400, message = "主键ids的长度必须小于等于400")
    private String remindIds;//主键ids，逗号分隔
}