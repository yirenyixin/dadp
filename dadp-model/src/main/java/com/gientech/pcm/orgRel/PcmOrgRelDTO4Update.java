package com.gientech.pcm.orgRel;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 【机构归属关系】PcmOrgRel修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "机构归属关系--修改DTO")
public class PcmOrgRelDTO4Update implements Serializable {
    @ApiModelProperty(value = "ORG_REL_ID", required = true, position = 1)
    @NotBlank(message = "ORG_REL_ID不能为空")
    @Size(max = 70, message = "ORG_REL_ID长度不能超过70位")
    private String orgRelId;

    @ApiModelProperty(value = "对私客户ID", position = 2)
    @NotBlank(message = "对私客户ID不能为空")
    @Size(max = 32, message = "对私客户ID长度不能超过32位")
    private String custId;

    @ApiModelProperty(value = "法人机构号", position = 3)
    @NotBlank(message = "法人机构号不能为空")
    @Size(max = 32, message = "法人机构号长度不能超过32位")
    private String lawOrgId;

    @ApiModelProperty(value = "ECIF客户ID", position = 4)
    @Size(max = 32, message = "ECIF客户ID长度不能超过32位")
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", position = 5)
    @Size(max = 128, message = "客户名称长度不能超过128位")
    private String custName;

    @ApiModelProperty(value = "归属机构编号", position = 6)
    @Size(max = 32, message = "归属机构编号长度不能超过32位")
    private String belongOrgId;

    @ApiModelProperty(value = "归属机构名称", position = 7)
    @Size(max = 128, message = "归属机构名称长度不能超过128位")
    private String belongOrgName;

    @ApiModelProperty(value = "机构主协办类型", position = 8)
    @Size(max = 32, message = "机构主协办类型长度不能超过32位")
    private String mainOrgType;

    @ApiModelProperty(value = "分配类型", position = 9)
    @Size(max = 32, message = "分配类型长度不能超过32位")
    private String assignType;

    @ApiModelProperty(value = "分配人编号", position = 10)
    @Size(max = 32, message = "分配人编号长度不能超过32位")
    private String assignUserId;

    @ApiModelProperty(value = "分配时间", position = 11)
    private Date assignDate;

}
