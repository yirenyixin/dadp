package com.gientech.pcm.userRel;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 【客户经理归属关系】PcmUserRel查询DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "客户经理归属关系--查询DTO")
public class PcmUserRelDTO4List implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "当前页码", required = true, position = 1)
    @NotNull(message = "[pageNo]当前页码，不能为空")
    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
    private Integer pageNo;// 当前页码

    @ApiModelProperty(value = "每页大小", required = true, position = 2)
    @NotNull(message = "[pageSize]每页大小，不能为空")
    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
    private Integer pageSize;// 每页大小

    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
    private String sort;// 排序字段名,多个逗号分隔

    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
    private String order;// 按什么排序(asc,desc)

    @JsonIgnore
    private String orderBy;// 排序sql片段

    // -----------------分割线---------------------------------------

//    @ApiModelProperty(value = "ID", required = true, position = 11)
//    @NotBlank(message = "ID不能为空")
//    @Size(max = 70, message = "ID长度不能超过70个字符")
//    private String userRelId;
//
//    @ApiModelProperty(value = "对私客户ID", required = true, position = 21)
//    @NotBlank(message = "对私客户ID不能为空")
//    @Size(max = 32, message = "对私客户ID长度不能超过32个字符")
//    private String custId;
//
//    @ApiModelProperty(value = "法人机构号", required = true, position = 13)
//    @NotBlank(message = "法人机构号不能为空")
//    @Size(max = 32, message = "法人机构号长度不能超过32个字符")
//    private String lawOrgId;
//
//    @ApiModelProperty(value = "ECIF客户ID", required = true, position = 14)
//    @Size(max = 32, message = "ECIF客户ID长度不能超过32个字符")
//    private String ecifCustId;
//
//    @ApiModelProperty(value = "客户名称", required = true, position = 15)
//    @Size(max = 128, message = "客户名称长度不能超过128个字符")
//    private String custName;
//
//    @ApiModelProperty(value = "归属客户经理编号", position = 16)
//    @Size(max = 32, message = "归属客户经理编号长度不能超过32个字符")
//    private String belongMgrId;
//
//    @ApiModelProperty(value = "归属客户经理名称", position = 17)
//    @Size(max = 128, message = "归属客户经理名称长度不能超过128个字符")
//    private String belongMgrName;
//
//    @ApiModelProperty(value = "客户经理主协办类型", allowableValues = "1,2,3,4", position = 18)
//    @Size(max = 32, message = "客户经理主协办类型长度不能超过32个字符")
//    private String mainMgrType;
//
//    @ApiModelProperty(value = "分配类型", allowableValues = "1,2", position = 19)
//    @Size(max = 32, message = "分配类型长度不能超过32个字符")
//    private String assignType;
//
//    @ApiModelProperty(value = "托管开始时间", position = 20)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    private Date beginDate;
//
//    @ApiModelProperty(value = "托管结束时间", position = 21)
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
//    private Date endDate;
//
//    @ApiModelProperty(value = "分配人编号", position = 22)
//    @Size(max = 32, message = "分配人编号长度不能超过32个字符")
//    private String assignUserId;
//
//    @ApiModelProperty(value = "分配时间", position = 23)
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date assignDate;

}
