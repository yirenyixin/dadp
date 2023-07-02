package com.gientech.sys.bookState;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 图书状态实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_BOOK_STATE")
public class SysBookState implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BOOK_ID", type = IdType.INPUT)
    private String bookId; // 图书ID

    @TableField(value = "ROLE_ID")
    private String roleId; // 角色ID

    @TableField(value = "BOOK_NAME")
    private String bookName; // 图书名

}