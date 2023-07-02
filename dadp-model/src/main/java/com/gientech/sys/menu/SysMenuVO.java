package com.gientech.sys.menu;

import com.baomidou.mybatisplus.annotation.Version;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单实体类，和数据库完全对应【此类不可修改】
 */
@Data
public class SysMenuVO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "菜单ID", position = 1)
    private String menuId;// 菜单ID

    @ApiModelProperty(value = "菜单名称", position = 2)
    private String menuName;// 菜单名称

    @ApiModelProperty(value = "上级菜单ID", position = 3)
    private String parentMenuId;// 上级菜单ID

    @ApiModelProperty(value = "菜单URL", position = 4)
    private String menuUrl;// 菜单URL

    @ApiModelProperty(value = "是否绝对路径", position = 5)
    private String isAllPath;// 是否绝对路径

    @ApiModelProperty(value = "图标地址", position = 6)
    private String imageUrl;// 图标地址

    @ApiModelProperty(value = "是否显示", position = 7)
    private String isShow;// 是否显示

    @ApiModelProperty(value = "排序号", position = 8)
    private Integer sortNo;// 排序号

    @ApiModelProperty(value = "备注", position = 9)
    private String remark;// 备注

    @ApiModelProperty(value = "数据版本", position = 10)
    @Version // 乐观锁,防止串改
    private Integer ver;// 数据版本

    @ApiModelProperty(value = "是否为叶子节点", position = 11)
    private Boolean isLeaf;// 是否为叶子节点

    @ApiModelProperty(value = "子树", position = 12)
    private List<SysMenuVO> childrenMenuList;

}