package com.gientech.sys.bookState;

import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【图书状态】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysBookStateVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID", position = 1)
    private String bookId; // 图书ID

    @ApiModelProperty(value = "角色ID", position = 2)
    private String roleId; // 角色ID

    @ApiModelProperty(value = "图书名", position = 3)
    private String bookName; // 图书名

    // -----------------分割线---------------------------------------

}
