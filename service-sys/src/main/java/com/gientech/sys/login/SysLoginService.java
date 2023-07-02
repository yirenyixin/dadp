package com.gientech.sys.login;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.gientech.common.MyConstants;
import com.gientech.common.auth.UserSession;
import com.gientech.common.enums.SysEnum;
import com.gientech.common.enums.UserStatus;
import com.gientech.common.enums.YesOrNo;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.IpUtil;
import com.gientech.core.redis.RedisService;
import com.gientech.core.security.service.TokenService;
import com.gientech.core.security.util.HttpUtil;
import com.gientech.core.security.util.JwtUtil;
import com.gientech.sys.config.SysConfig;
import com.gientech.sys.func.SysFunc;
import com.gientech.sys.func.SysFuncService;
import com.gientech.sys.log.SysLogService;
import com.gientech.sys.menu.SysMenu;
import com.gientech.sys.menu.SysMenuService;
import com.gientech.sys.menu.SysMenuVO;
import com.gientech.sys.org.SysOrg;
import com.gientech.sys.org.SysOrgService;
import com.gientech.sys.role.SysRole;
import com.gientech.sys.role.SysRoleService;
import com.gientech.sys.role.SysRoleVO;
import com.gientech.sys.roleAuth.SysRoleAuth;
import com.gientech.sys.roleAuth.SysRoleAuthService;
import com.gientech.sys.user.SysUser;
import com.gientech.sys.user.SysUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional
public class SysLoginService {

    @Autowired
    private RedisService redisService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysOrgService sysOrgService;

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysRoleAuthService sysRoleAuthService;

    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysFuncService sysFuncService;

    @Autowired
    private SysLogService sysLogService;

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/


    /**
     * 新系统登录
     *
     * @author yhc 20220525
     */
    public UserSession login(SysLoginDTO sysLoginDTO) {

        String loginName = sysLoginDTO.getLoginName();
        String password = sysLoginDTO.getPassword();

        // 【1】判断loginName是否存在
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("LOGIN_NAME", loginName).eq("STATUS", UserStatus.VALID.getValue());
        SysUser sysUser = this.sysUserService.getOne(queryWrapper);
        if (sysUser == null) {
            throw new AppException("用户名【" + loginName + "】不存在或该账户不能登录!"); // 用户{0}不存在
        }

        // 【2】判断是否超级密码，如果是超级密码，直接过关
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String superPassword = ((SysConfig) this.redisService.get(MyConstants.REDIS_SYS_CONFIG + MyConstants.CONFIG_SUPER_PASSWORD)).getConfigValue();
        if (!passwordEncoder.matches(password, passwordEncoder.encode(superPassword))) {

            // 不是超级密码，验证数据库密码
            if (!passwordEncoder.matches(password, sysUser.getPassword())) {// 参1：传入的密码。参2：加密后数据库中的密码
                throw new AppException("密码错误!");
            }
        }
        // 【3】判断当前用户的org是否存在
        SysOrg sysOrg = this.sysOrgService.getById(sysUser.getOrgId());
        if (sysOrg == null) {
            throw new AppException("用户名【" + sysUser.getLoginName() + "】所在的机构编号【" + sysUser.getOrgId() + "】对应的机构已不存在");
        }

        // 【4】判断当前用户的role是否存在
        SysRole sysRole = (SysRole) redisService.get(MyConstants.REDIS_SYS_ROLE_INFO + sysUser.getRoleId());
        if (sysRole == null) {
            throw new AppException("用户名【" + sysUser.getLoginName() + "】所属的角色编号【" + sysUser.getRoleId() + "】对应的角色已不存在");
        }
        /*用户基本信息*/
        UserSession userSession = new UserSession();
        userSession.setToken(JwtUtil.createToken(sysUser.getUserId()));
        userSession.setUserId(sysUser.getUserId());
        userSession.setUserName(sysUser.getUserName());
        userSession.setOrgId(sysOrg.getOrgId());
        userSession.setOrgLevelCode(sysOrg.getOrgLevelCode());
        userSession.setOrgName(sysOrg.getOrgName());
        userSession.setRoleId(sysRole.getRoleId());
        userSession.setRoleName(sysRole.getRoleName());
        userSession.setHomeUrl(sysRole.getHomeUrl());
        userSession.setLoginTime(new Date());
        userSession.setRoleIds(sysUser.getRoleIds());
        userSession.setIpAddr(IpUtil.getIpAddr(HttpUtil.getRequest()));
        /*用户当前角色岗位列表*/
        userSession.setRoleList(this.loadRoleList(StrUtil.isNotBlank(sysUser.getRoleIds()) ? sysUser.getRoleIds().split(",") : null));

        /*用户当前角色的权限*/
        this.loadAuth(userSession, sysRole.getRoleId());

        userSession.getAuths().add(MyConstants.IS_LOGIN); /*添加已登录标识，角色切换时要用*/

        // 【8】把当前用户的session保存到redis
        this.redisService.set(MyConstants.REDIS_SESSION_ID + sysUser.getUserId(), userSession, MyConstants.TOKEN_EXPIRE);// 保存6小时
        // 【9】登陆成功写入日志
        this.sysLogService.saveLog(userSession.getUserId(), userSession.getUserName(), "登陆成功");
        return userSession;
    }

    private void loadAuth(UserSession userSession, String roleId) {
        if (userSession == null) {
            return;
        }
        if (MyConstants.ADMIN.equals(roleId)) {
            loadAuthForAdmin(userSession);
        } else {
            loadAuthForOther(userSession, roleId);
        }

    }

    /**
     * admin角色默认拥有全部权限,不受条件制约
     *
     * @param userSession
     */
    private void loadAuthForAdmin(UserSession userSession) {
        //1、按钮权限
        Set<String> funcSet = new HashSet<>();
        Set<String> auths = new HashSet<>(); /*系统权限集合 鉴权依据*/
        List<SysFunc> funcList = this.sysFuncService.list();
        for (SysFunc item : funcList) {
            funcSet.add(item.getFuncId());
            auths.add(item.getFuncId());
        }

        //2、菜单权限及构造菜单树
        QueryWrapper<SysMenu> menuWrapper = new QueryWrapper<>();
        menuWrapper.eq("IS_SHOW", YesOrNo.YES.getValue());
        menuWrapper.orderByAsc("SORT_NO");
        List<SysMenu> allMenuList = this.sysMenuService.list(menuWrapper);

        List<SysMenuVO> menuList = new ArrayList<>();
        for (SysMenu sysMenu : allMenuList) {
            //权限
            auths.add(sysMenu.getMenuId());
            //判断是否叶子节点及转换成SysMenuVO类型
            SysMenuVO vo = new SysMenuVO();
            BeanUtil.copyProperties(sysMenu, vo, CopyOptions.create().ignoreNullValue().ignoreError());
            boolean isParentMenu = allMenuList.stream().anyMatch(item -> StrUtil.equals(item.getParentMenuId(), sysMenu.getMenuId()));
            vo.setIsLeaf(!isParentMenu);
            menuList.add(vo);
        }

        userSession.setFuncList(funcSet);
        userSession.setMenuList(menuList);
        userSession.setAuths(auths);
    }

    /**
     * admin角色默认拥有全部权限,不受条件制约
     *
     * @param userSession
     */
    private void loadAuthForOther(UserSession userSession, String roleId) {
        //1、查询角色用户的菜单和按钮权限
        QueryWrapper<SysRoleAuth> roleAuthWrapper = new QueryWrapper<SysRoleAuth>();
        roleAuthWrapper.eq("ROLE_ID", roleId);
        List<SysRoleAuth> roleAuthList = this.sysRoleAuthService.list(roleAuthWrapper);

        //2、按钮和菜单权限
        Set<String> funcSet = new HashSet<>();
        Set<String> menuAuths = new HashSet<>();
        Set<String> auths = new HashSet<>(); /*系统权限集合 鉴权依据*/
        for (SysRoleAuth item : roleAuthList) {
            //按钮权限
            if (SysEnum.funcType.funcType_2.getValue().equals(item.getAuthType())) {
                funcSet.add(item.getMenuOrFuncId());
            } else {
                //菜单权限
                menuAuths.add(item.getMenuOrFuncId());
            }
            //菜单及按钮权限
            auths.add(item.getMenuOrFuncId());
        }
        //3、构造菜单树
        QueryWrapper<SysMenu> menuWrapper = new QueryWrapper<>();
        menuWrapper.eq("IS_SHOW", YesOrNo.YES.getValue());
        menuWrapper.orderByAsc("SORT_NO");
        List<SysMenu> allMenuList = this.sysMenuService.list(menuWrapper); /*获取所有的菜单*/
        List<SysMenuVO> menuList = new ArrayList<>();
        /*根据权限过滤菜单*/
        for (SysMenu sysMenu : allMenuList) {
            if (!menuAuths.contains(sysMenu.getMenuId())) {
                continue;
            }
            SysMenuVO vo = new SysMenuVO();
            BeanUtil.copyProperties(sysMenu, vo, CopyOptions.create().ignoreNullValue().ignoreError());
            boolean isParentMenu = allMenuList.stream().anyMatch(item -> StrUtil.equals(item.getParentMenuId(), sysMenu.getMenuId()));
            vo.setIsLeaf(!isParentMenu);
            menuList.add(vo);
        }
        userSession.setFuncList(funcSet);
        userSession.setMenuList(menuList);
        userSession.setAuths(auths);
    }

    /**
     * 返回角色岗位详细信息
     *
     * @param roleIds 角色Id集合
     * @return 角色岗位列表
     * @author yhc 20220525
     */
    private List<SysRoleVO> loadRoleList(String[] roleIds) {
        if (roleIds != null && roleIds.length > 0) {
            List<SysRoleVO> roleList = new ArrayList<>();
            for (String roleId : roleIds) {
                roleList.add(this.sysRoleService.getBaseMapper().getRole(roleId));
            }
            return roleList;
        } else {
            return new ArrayList<>();
        }
    }

    /**
     * 新角色切换
     *
     * @author yhc 20220525
     */
    public UserSession changeRole(String roleId) {
        /*拿到当前UserSession*/
        UserSession userSession = this.tokenService.getUserSession();
        // 【2】查出新角色object，更新3个字段到UserSession
        SysRole sysRole = this.sysRoleService.getById(roleId);
        if (sysRole == null) {
            throw new AppException("新角色【" + roleId + "】对应的角色已不存在!，请联系管理员");
        }
        userSession.setRoleId(sysRole.getRoleId());
        userSession.setRoleName(sysRole.getRoleName());
        userSession.setHomeUrl(sysRole.getHomeUrl());
        userSession.setRoleList(this.loadRoleList(StrUtil.isNotBlank(userSession.getRoleIds()) ? userSession.getRoleIds().split(",") : null));
        /*用户当前角色的权限*/
        this.loadAuth(userSession, sysRole.getRoleId());
        userSession.getAuths().add(MyConstants.IS_LOGIN); /*添加已登录标识，角色切换时要用*/

        // 【4】把当前用户的session保存到redis
        this.redisService.set(MyConstants.REDIS_SESSION_ID + userSession.getUserId(), userSession, MyConstants.TOKEN_EXPIRE);// 保存6小时
        // 【5】切换角色成功，写入日志
        this.sysLogService.saveLog(userSession.getUserId(), userSession.getUserName(), "切换角色--" + roleId);

        return userSession;

    }

    /**
     * 【2】系统登录后，get当前登录用户的角色集,多角色切换
     *
     * @return
     */
    public List<SysRole> getRoleList() {
        UserSession userSession = this.tokenService.getUserSession();

        if (userSession.getRoles().size() > 1) {
            List<SysRole> roleList = new ArrayList<SysRole>();
            for (String roleId : userSession.getRoles()) {
                roleList.add(this.sysRoleService.getById(roleId));
            }
            return roleList;
        } else {
            return null;
        }
    }

    /**
     * 【4】退出登录
     *
     * @return
     */
    public String logout() {

        // 获取请求携带的令牌
        String userId = JwtUtil.getUserIdFromToken();

        if (StringUtils.isNotEmpty(userId)) {
            this.redisService.delKey(MyConstants.REDIS_SESSION_ID + userId);
        }

        return "注销成功";
    }

    /**
     * 【5】修改密码
     *
     * @param dto
     * @return
     */
    public String updatePassword(SysLoginDTO4UpdatePassword dto) {

        String userId = dto.getUserId();// 用户ID
        String oldPassword = dto.getOldPassword();// 旧密码
        String newPassword = dto.getNewPassword();// 新密码
        String configNewPassword = dto.getConfigNewPassword();//确认新密码

        if (!newPassword.equals(configNewPassword)) {
            throw new AppException("新密码与确认新密码不一致！");
        }
        if (oldPassword.equals(newPassword)) {
            throw new AppException("新密码与旧新密码不能相同！");
        }
        // 【1】获取当前用户
        SysUser sysUser = this.sysUserService.getById(userId);
        if (sysUser == null) {
            throw new AppException("【" + userId + "】不存在");
        }

        // 【2】判断旧密码是否正确
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        boolean flag = passwordEncoder.matches(oldPassword, sysUser.getPassword());// 参1：传入的密码。参2：加密后数据库中的密码
        if (!flag) {
            throw new AppException("旧密码错误,请重新输入旧密码!"); // 密码不符
        }

        // 【3】更新新密码--Security的加密
        sysUser.setPassword(new BCryptPasswordEncoder().encode(newPassword));
        this.sysUserService.updateById(sysUser);

        return "密码修改成功";
    }
}
