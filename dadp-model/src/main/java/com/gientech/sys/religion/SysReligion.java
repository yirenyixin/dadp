package com.gientech.sys.religion;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * 宗教实体类，和数据库完全对应【此类不可修改】
 */
@Data
@TableName(value = "T_SYS_RELIGION")
public class SysReligion implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "RELIGION_ID", type = IdType.INPUT)
    private String religionId;// 宗教ID

    @TableField(value = "RELIGION_NAME")
    private String religionName;// 宗教名称

    @TableField(value = "SORT_NO")
    private Integer sortNo;// 排序号

    @TableField(value = "REMARK")
    private String remark;// 备注

    @TableField(value = "VER")
    @Version // 乐观锁,防止串改
    private Integer ver;// 数据版本
}
