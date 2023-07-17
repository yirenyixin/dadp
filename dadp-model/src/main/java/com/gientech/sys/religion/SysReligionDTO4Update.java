package com.gientech.sys.religion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;
import java.io.Serializable;
/**
 * 【宗教】SysReligion修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "宗教--修改DTO")
public class SysReligionDTO4Update implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "宗教ID", required = true, position = 1)
    @NotBlank(message = "[religionId]宗教ID，不能为空")
    @Size(max = 32, message = "宗教ID的长度必须小于等于32")
    private String religionId;// 宗教ID

    @ApiModelProperty(value = "宗教名称", required = true, position = 2)
    @NotBlank(message = "[religionName]宗教名称，不能为空")
    @Size(max = 100, message = "宗教名称的长度必须小于等于100")
    private String religionName;// 宗教名称

    @ApiModelProperty(value = "排序号", required = true, position = 3)
    @NotNull(message = "[sortNo]排序号，不能为空")
    @Min(value = 0, message = "[sortNo]排序号不能小于0")
    @Max(value = 99999, message = "[sortNo]排序号不能大于{value}")
    private Integer sortNo;// 排序号

    @ApiModelProperty(value = "备注", position = 4)
    @Size(max = 400, message = "备注的长度必须小于等于400")
    private String remark;// 备注
}
