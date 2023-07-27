package com.gientech.sys.religion;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
/**
 * 【宗教】查询结果的VO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
public class SysReligionVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "宗教ID", position = 1)
    private String religionId;// 宗教ID

    @ApiModelProperty(value = "宗教名称", position = 2)
    private String religionName;// 宗教名称

    @ApiModelProperty(value = "排序号", position = 3)
    private Integer sortNo;// 排序号

    @ApiModelProperty(value = "备注", position = 4)
    private String remark;// 备注

    @ApiModelProperty(value = "数据版本", position = 5)
    private Integer ver;// 数据版本
}
