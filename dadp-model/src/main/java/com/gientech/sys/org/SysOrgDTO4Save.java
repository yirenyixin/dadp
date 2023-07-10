package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 19:59
 */
@Data
@ApiModel(value = "机构--新增DTO")
public class SysOrgDTO4Save implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "机构ID", required = true, position = 1)
    @NotBlank(message = "[orgId]机构ID，不能为空")
    @Size(max = 32, message = "机构ID的长度必须小于等于32")
    private String orgId;// 机构ID

    @ApiModelProperty(value = "机构名称", required = true, position = 2)
    @NotBlank(message = "[orgName]机构名称，不能为空")
    @Size(max = 100, message = "机构名称的长度必须小于等于100")
    private String orgName;// 机构名称

    @ApiModelProperty(value = "机构简称", required = true, position = 3)
    @NotBlank(message = "[shortName]机构简称，不能为空")
    @Size(max = 100, message = "机构简称的长度必须小于等于100")
    private String shortName;// 机构简称

    @ApiModelProperty(value = "上级机构ID",position = 4)
    @Size(max = 32, message = "上级机构ID的长度必须小于等于32")
    private String parentOrgId;// 上级机构ID

    @ApiModelProperty(value = "机构类型", required = true, position = 5)
    @NotBlank(message = "[orgType]机构类型，不能为空")
    @Size(max = 4, message = "机构类型的长度必须小于等于4")
    private String orgType;// 机构类型

//    @ApiModelProperty(value = "是否法人机构", required = true, position = 6)
//    @NotBlank(message = "[isLawOrg]是否法人机构，不能为空")
//    @Size(max = 1, message = "是否法人机构的长度必须小于等于1")
//    private String isLawOrg;// 是否法人机构

    @ApiModelProperty(value = "法人机构ID", position = 7)
    @Size(max = 32, message = "法人机构ID的长度必须小于等于32")
    private String lawOrgId;// 法人机构ID

//    @ApiModelProperty(value = "机构级次", required = true, position = 8)
//    @NotNull(message = "[orgLevel]机构级次，不能为空")
//    @Size(max = 1, message = "机构级次的长度必须小于等于1")
//    private Integer orgLevel;// 机构级次
//
//    @ApiModelProperty(value = "机构级次码", required = true, position = 9)
//    @NotBlank(message = "[orgLevelCode]机构级次码，不能为空")
//    @Size(max = 100, message = "机构级次码的长度必须小于等于100")
//    private String orgLevelCode;// 机构级次码

    @ApiModelProperty(value = "部门机构电话", position = 10)
    @Size(max = 20, message = "部门机构电话的长度必须小于等于20")
    private String tel;// 联系电话

    @ApiModelProperty(value = "部门机构地址",  position = 11)
    @Size(max = 120, message = "部门机构地址的长度必须小于等于120")
    private String addr;// 联系地址

//    @ApiModelProperty(value = "更新时间",  position = 12)
//    @Size(max = 14, message = "更新时间的长度必须小于等于14")
//    private String updateTime;// 更新时间

    @ApiModelProperty(value = "排序号", position = 13)
    @NotNull(message = "[sortNo]排序号，不能为空")
    //@Size(max = 4, message = "备注的长度必须小于等于4")
    private Integer sortNo;// 排序号

    @ApiModelProperty(value = "备注", position = 14)
    @Size(max = 400, message = "备注的长度必须小于等于400")
    private String remark;// 备注
}