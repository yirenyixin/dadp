package com.gientech.pcm.cust;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 【客户】PcmCust删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "客户--删除DTO")
public class PcmCustDTO4Delete implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "客户ids,逗号分隔", required = true, position = 1)
    @NotBlank(message = "[custIds]客户ids，不能为空")
    @Size(max = 400, message = "主键ids，的长度必须小于等于400")
    private String custIds;// 客户ids,逗号分隔
}
