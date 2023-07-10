package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 20:39
 */
@Data
@ApiModel(value = "机构--get对象DTO")
public class SysOrgDTO4Get implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id", required = true, position = 1)
    @NotBlank(message = "[orgId]主键id，不能为空")
    @Size(max = 32, message = "主键id，的长度必须小于等于32")
    private String orgId;// 主键id

    // -----------------分割线---------------------------------------

}