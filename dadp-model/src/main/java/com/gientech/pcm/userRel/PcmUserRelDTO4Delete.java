package com.gientech.pcm.userRel;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 【客户经理归属关系】PcmUserRel删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "客户经理归属关系--删除DTO")
public class PcmUserRelDTO4Delete implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "userRelIds,逗号分隔", required = true, position = 1)
    @NotBlank(message = "[userRelIds]userRelIds，不能为空")
    @Size(max = 400, message = "主键ids，的长度必须小于等于400")
    private String userRelIds;
}
