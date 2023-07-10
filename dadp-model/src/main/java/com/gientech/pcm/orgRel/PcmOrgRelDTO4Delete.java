package com.gientech.pcm.orgRel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;


/**
 * 【机构归属关系】PcmOrgRel删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构归属关系--删除DTO")
public class PcmOrgRelDTO4Delete implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "orgRelIds,逗号分隔", required = true, position = 1)
    @NotBlank(message = "[orgRelIds]orgRelIds，不能为空")
    @Size(max = 400, message = "主键ids，的长度必须小于等于400")
    private String orgRelIds;

}
