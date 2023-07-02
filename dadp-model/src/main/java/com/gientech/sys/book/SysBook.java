package com.gientech.sys.book;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 * 图书实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_BOOK")
public class SysBook implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "BOOK_ID", type = IdType.INPUT)
    private String bookId; // 图书ID

    @TableField(value = "BOOK_NAME")
    private String bookName; // 图书名称

    @TableField(value = "AUTHOR")
    private String author; // 作者

    @TableField(value = "CREATE_TIME")
    private Date createTime; // 创建时间

    @TableField(value = "ROLE")
    private String role; // 角色

    @TableField(value = "ROLE_ID")
    private String roleId; // 角色ID

}