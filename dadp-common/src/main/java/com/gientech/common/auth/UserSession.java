package com.gientech.common.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gientech.common.MyConstants;
import com.gientech.sys.menu.SysMenuVO;
import com.gientech.sys.role.SysRoleVO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
public class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(name = "按钮权限", position = 100)
    private Set<String> funcList;

    @ApiModelProperty(name = "菜单树", position = 101)
    private List<SysMenuVO> menuList;

    @ApiModelProperty(name = "拥有角色岗位集合", position = 102)
    private List<SysRoleVO> roleList;

    private String token;// 用户唯一标识

    private String userId;// 用户ID

    private String userName;// 用户姓名

    private String orgId;// 所属机构ID

    private String orgName;// 所属机构名

    private String orgLevelCode;// 机构级次码

    private String roleId;// 当前角色ID

    private String roleName;// 当前角色名

    private String roleIds;//多角色以","分隔

    private String homeUrl;// 当前角色登录后，跳转的首页url

    private Set<String> auths; // 菜单权限码和功能权限码， 数据集List<menuId>,

    private Set<String> roles;// 角色列表,java端鉴权用

    private String ipAddr; // 登陆ip地址

    private Date loginTime; // 登陆时间

    @JsonIgnore
    public boolean isAdmin() {
        return MyConstants.ADMIN.equals(this.userId);
    }
}
