package com.gientech.sys.book;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 【图书】SysBook修改DTO类【不要的属性，一定要删除！发现3次要开除】
 */
@Data
@ApiModel(value = "图书--修改DTO")
public class SysBookDTO4Update implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "图书ID", required = true, position = 1)
    @NotBlank(message = "[bookId]图书ID，不能为空")
    @Size(max = 32, message = "图书ID的长度必须小于等于32")
    private String bookId; // 图书ID

    @ApiModelProperty(value = "图书名称", required = true, position = 2)
    @NotBlank(message = "[bookName]图书名称，不能为空")
    @Size(max = 100, message = "图书名称的长度必须小于等于100")
    private String bookName; // 图书名称

    @ApiModelProperty(value = "作者", required = true, position = 3)
    @NotBlank(message = "[author]作者，不能为空")
    @Size(max = 50, message = "作者的长度必须小于等于50")
    private String author; // 作者

    @ApiModelProperty(value = "角色", required = true, position = 4)
    @NotBlank(message = "[role]角色，不能为空")
    private String role; // 角色

    @ApiModelProperty(value = "角色ID", required = true, position = 5)
    @NotBlank(message = "[roleId]角色ID，不能为空")
    @Size(max = 32, message = "角色ID的长度必须小于等于32")
    private String roleId; // 角色ID

    @ApiModelProperty(value = "排序号", required = true, position = 6)
    @NotNull(message = "[sortNo]排序号，不能为空")
    @Min(value = 0, message = "排序号不能小于0")
    @Max(value = 9999, message = "排序号不能大于{value}")
    private Integer sortNo; // 排序号

    @ApiModelProperty(value = "数据版本", required = true, position = 7)
    @NotNull(message = "[ver]数据版本，不能为空")
    @Min(value = 0, message = "数据版本，不能小于0")
    @Max(value = 99999, message = "数据版本，不能大于{value}")
    private Integer ver; // 数据版本


    @ApiModelProperty(value = "创建时间", required = true, position = 8)
    @NotNull(message = "[createTime]创建时间，不能为空")
    private Date createTime; // 创建时间
    // -----------------分割线---------------------------------------

}
