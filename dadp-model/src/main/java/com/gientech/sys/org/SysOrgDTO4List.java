package com.gientech.sys.org;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author cjm
 * @date 2023/7/8 20:15
 */
@Data
@ApiModel(value = "机构--查询DTO")
public class SysOrgDTO4List implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "上级节点id", position = 1)
    private String topOrgId;// 上级节点id

    // -----------------分割线---------------------------------------

}
//public class SysOrgDTO4List implements Serializable {
//
//    private static final long serialVersionUID = 1L;
//
//    @ApiModelProperty(value = "当前页码", required = true, position = 1)
//    @NotNull(message = "[pageNo]当前页码，不能为空")
//    @Min(value = 1, message = "[pageNo]当前页码，不能小于1")
//    @Max(value = Integer.MAX_VALUE, message = "[pageNo]当前页码，不能大于" + Integer.MAX_VALUE)
//    private Integer pageNo;// 当前页码
//
//    @ApiModelProperty(value = "每页大小", required = true, position = 2)
//    @NotNull(message = "[pageSize]每页大小，不能为空")
//    @Min(value = 1, message = "[pageSize]每页大小，不能小于1")
//    @Max(value = 100, message = "[pageSize]每页大小，不能超过{value}")
//    private Integer pageSize;// 每页大小
//
//    @ApiModelProperty(value = "排序字段名,多个逗号分隔", position = 3)
//    private String sort;// 排序字段名,多个逗号分隔
//
//    @ApiModelProperty(value = "按什么排序,多个逗号分隔", position = 4)
//    private String order;// 按什么排序(asc,desc)
//
//    @JsonIgnore
//    private String orderBy;// 排序sql片段
//
//    // -----------------分割线---------------------------------------
//}