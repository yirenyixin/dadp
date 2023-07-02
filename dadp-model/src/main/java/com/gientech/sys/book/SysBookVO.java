package com.gientech.sys.book;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【图书】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysBookVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID", position = 1)
    private String bookId; // 图书ID

    @ApiModelProperty(value = "图书名称", position = 2)
    private String bookName; // 图书名称

    @ApiModelProperty(value = "作者", position = 3)
    private String author; // 作者

    @ApiModelProperty(value = "创建时间", position = 4)
    private Date createTime; // 创建时间

    @ApiModelProperty(value = "角色", position = 5)
    private String role; // 角色

    @ApiModelProperty(value = "角色ID", position = 6)
    private String roleId; // 角色ID

    // -----------------分割线---------------------------------------

}