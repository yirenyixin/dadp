package com.gientech.sys.bookState;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【图书状态】SysBookState新增DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "图书状态--新增DTO")
public class SysBookStateDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID", required = true, position = 1)
    @NotBlank(message = "[bookId]图书ID，不能为空")
    @Size(max = 32, message = "图书ID的长度必须小于等于32")
    private String bookId; // 图书ID

    @ApiModelProperty(value = "角色ID", required = true, position = 2)
    @NotBlank(message = "[roleId]角色ID，不能为空")
    @Size(max = 32, message = "角色ID的长度必须小于等于32")
    private String roleId; // 角色ID

    // -----------------分割线---------------------------------------

}
