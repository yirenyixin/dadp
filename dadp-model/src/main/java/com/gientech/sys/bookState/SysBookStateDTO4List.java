package com.gientech.sys.bookState;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "图书状态--查询条件的DTO类")
@JsonIgnoreProperties(value = { "orderBy" })
public class SysBookStateDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码，不能为空")
    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
    private Integer pageNo;

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小，不能为空")
    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
    private Integer pageSize;

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort;

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order;

    @JsonIgnore
    private String orderBy;



    @ApiModelProperty(value = "图书ID", position = 5)
    private String bookId;

    @ApiModelProperty(value = "角色ID", position = 6)
    private String roleId;

    @ApiModelProperty(value = "图书名", position = 7)
    private String bookName; // 图书名


    // getter和setter方法，省略其他部分
}
