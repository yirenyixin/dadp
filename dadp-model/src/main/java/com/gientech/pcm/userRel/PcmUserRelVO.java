package com.gientech.pcm.userRel;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

/**
 * 客户经理归属关系查询结果的VO类，和数据库完全对应【此类不可修改】
 */
@Data

public class PcmUserRelVO implements Serializable {
    @ApiModelProperty(value = "ID", required = true, position = 1)
    @NotBlank(message = "ID不能为空")
    @Size(max = 70, message = "ID长度不能超过70个字符")
    private String userRelId;

    @ApiModelProperty(value = "对私客户ID", required = true, position = 2)
    @NotBlank(message = "对私客户ID不能为空")
    @Size(max = 32, message = "对私客户ID长度不能超过32个字符")
    private String custId;

    @ApiModelProperty(value = "法人机构号", required = true, position = 3)
    @NotBlank(message = "法人机构号不能为空")
    @Size(max = 32, message = "法人机构号长度不能超过32个字符")
    private String lawOrgId;

    @ApiModelProperty(value = "ECIF客户ID", required = true, position = 4)
    @Size(max = 32, message = "ECIF客户ID长度不能超过32个字符")
    private String ecifCustId;

    @ApiModelProperty(value = "客户名称", required = true, position = 5)
    @Size(max = 128, message = "客户名称长度不能超过128个字符")
    private String custName;

    @ApiModelProperty(value = "归属客户经理编号", position = 6)
    @Size(max = 32, message = "归属客户经理编号长度不能超过32个字符")
    private String belongMgrId;

    @ApiModelProperty(value = "归属客户经理名称", position = 7)
    @Size(max = 128, message = "归属客户经理名称长度不能超过128个字符")
    private String belongMgrName;

    @ApiModelProperty(value = "客户经理主协办类型", allowableValues = "1,2,3,4", position = 8)
    @Size(max = 32, message = "客户经理主协办类型长度不能超过32个字符")
    private String mainMgrType;

    @ApiModelProperty(value = "分配类型", allowableValues = "1,2", position = 9)
    @Size(max = 32, message = "分配类型长度不能超过32个字符")
    private String assignType;

    @ApiModelProperty(value = "托管开始时间", position = 10)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date beginDate;

    @ApiModelProperty(value = "托管结束时间", position = 11)
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;

    @ApiModelProperty(value = "分配人编号", position = 12)
    @Size(max = 32, message = "分配人编号长度不能超过32个字符")
    private String assignUserId;

    @ApiModelProperty(value = "分配时间", position = 13)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date assignDate;
}
