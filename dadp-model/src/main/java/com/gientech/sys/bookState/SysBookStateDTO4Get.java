package com.gientech.sys.bookState;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【图书状态】SysBookState图书授权DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "图书状态--图书授权DTO")
public class SysBookStateDTO4Get implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID", required = true, position = 1)
    @NotBlank(message = "[bookId]图书ID不能为空")
    @Size(max = 32, message = "图书ID长度必须小于等于32")
    private String bookId; // 图书ID



    // -----------------分割线---------------------------------------
}
