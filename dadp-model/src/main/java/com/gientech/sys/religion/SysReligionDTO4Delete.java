package com.gientech.sys.religion;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
/**
 * 【宗教】SysReligion删除DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "宗教--删除DTO")
public class SysReligionDTO4Delete implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键ids,逗号分隔", required = true, position = 1)
    @NotBlank(message = "[religionId]主键id，不能为空")
    @Size(max = 32, message = "主键id，的长度必须小于等于32")
    private String religionIds;// 主键id

}
