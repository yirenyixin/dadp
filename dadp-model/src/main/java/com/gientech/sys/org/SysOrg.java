package com.gientech.sys.org;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 19:49
 */
@Data
@TableName(value = "T_SYS_ORG")
public class SysOrg implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ORG_ID", type = IdType.INPUT)
    private String orgId; // 机构ID

    @TableField(value = "ORG_NAME")
    private String orgName; // 机构名称

    @TableField(value = "SHORT_NAME")
    private String shortName; // 机构简称

    @TableField(value = "PARENT_ORG_ID")
    private String parentOrgId; // 上级机构ID

    @TableField(value = "ORG_TYPE")
    private String orgType; // 机构类型

    @TableField(value = "IS_LAW_ORG")
    private String isLawOrg; // 是否法人联社

    @TableField(value = "LAW_ORG_ID")
    private String lawOrgId; // 所属法人机构号

    @TableField(value = "ORG_LEVEL")
    private Integer orgLevel; // 机构级次

    @TableField(value = "ORG_LEVEL_CODE")
    private String orgLevelCode; // 机构级次码

    @TableField(value = "TEL")
    private String tel; // 部门机构电话

    @TableField(value = "ADDR")
    private String addr; // 部门机构地址

    @TableField(value = "UPDATE_TIME")
    private String updateTime; // 更新时间

    @TableField(value = "SORT_NO")
    private Integer sortNo; // 排序号

    @TableField(value = "REMARK")
    private String remark; // 备注

    @TableField(value = "VER")
    @Version // 乐观锁,防止串改
    private Integer ver; // 数据版本

}
