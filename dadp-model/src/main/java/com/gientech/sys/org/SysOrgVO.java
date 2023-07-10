package com.gientech.sys.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 19:54
 */
@Data
public class SysOrgVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构ID", position = 1)
    private String orgId; // 机构ID

    @ApiModelProperty(value = "机构名称", position = 2)
    private String orgName; // 机构名称

    @ApiModelProperty(value = "机构简称", position = 3)
    private String shortName; // 机构简称

    @ApiModelProperty(value = "上级机构ID", position = 4)
    private String parentOrgId; // 上级机构ID

    @ApiModelProperty(value = "机构类型", position = 5)
    private String orgType; // 机构类型

    @ApiModelProperty(value = "是否法人联社", position = 6)
    private String isLawOrg; // 是否法人联社

    @ApiModelProperty(value = "所属法人机构号", position = 7)
    private String lawOrgId; // 所属法人机构号

    @ApiModelProperty(value = "机构级次", position = 8)
    private Integer orgLevel; // 机构级次

    @ApiModelProperty(value = "机构级次码", position = 9)
    private String orgLevelCode; // 机构级次码

    @ApiModelProperty(value = "部门机构电话", position = 10)
    private String tel; // 部门机构电话

    @ApiModelProperty(value = "部门机构地址", position = 11)
    private String addr; // 部门机构地址

    @ApiModelProperty(value = "更新时间", position = 12)
    private String updateTime; // 更新时间

    @ApiModelProperty(value = "排序号", position = 13)
    private Integer sortNo; // 排序号

    @ApiModelProperty(value = "备注", position = 14)
    private String remark; // 备注

    @ApiModelProperty(value = "数据版本", position = 15)
    private Integer ver; // 数据版本

}