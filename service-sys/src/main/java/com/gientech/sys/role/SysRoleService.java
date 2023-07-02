package com.gientech.sys.role;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.MyConstants;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import com.gientech.sys.cache.SysCacheService;
import com.gientech.sys.roleAuth.SysRoleAuth;
import com.gientech.sys.roleAuth.SysRoleAuthService;
import com.gientech.sys.roleData.SysRoleData;
import com.gientech.sys.roleData.SysRoleDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 角色--Service
 *
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysRoleService extends BaseService<SysRoleMapper, SysRole> {

    @Autowired
    private SysRoleAuthService sysRoleAuthService;

    @Autowired
    private SysRoleDataService sysRoleDataService;

    @Autowired
    private SysCacheService sysCacheService;
    @Autowired
    private RedisService redisService;

    /**
     * 【1】查询和分页
     *
     * @param dto
     * @return
     */
    public DataGrid<SysRoleVO> listRole(SysRoleDTO4List dto) {
        log.info("【list查询条件--角色】" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "roleId,roleName,remark");

        // 【2】处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "a.SORT_NO asc, a.ROLE_ID asc"));

        // 【3】构造分页参数
        Page<SysRoleVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<SysRoleVO>(this.getBaseMapper().getSysRoleList(page, dto), page.getTotal());
    }

    /**
     * 【2】新增--保存
     *
     * @param dto
     */
    public void saveRole(SysRoleDTO4Save dto) {
        log.info("【新增--角色】" + dto);

        // 【1】 从dto中copy属性
        SysRole sysRole = new SysRole();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysRole);

        // 【2】 校验id是否存在
        if (isExistRoleId(sysRole.getRoleId())) {
            throw new AppException("新增失败，角色ID【" + sysRole.getRoleId() + "】已经存在！");
        }

        sysRole.setVer(1);// 数据版本
        this.save(sysRole);

        sysCacheService.loadRoleToRedis();
    }

    /**
     * 【3】修改
     *
     * @param dto
     */
    public void updateRole(SysRoleDTO4Update dto) {
        log.info("【修改--角色】" + dto);

        // 【1】 从dto中copy属性
        SysRole sysRole = new SysRole();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysRole);

        if (!this.updateById(sysRole)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
        sysCacheService.loadRoleToRedis();
    }

    /**
     * 【4】删除--多个id以逗号分隔
     *
     * @param roleIds
     */
    public void deleteRole(String roleIds) {
        log.info("【删除--角色】" + roleIds);

        // 【1】删除
        String[] roleIdArray = StrUtil.splitToArray(roleIds, ",");
        for (String roleId : roleIdArray) {
            this.removeById(roleId);

            // 【2】要删除子表数据--操作权限
            QueryWrapper<SysRoleAuth> roleAuthWrapper = new QueryWrapper<>();
            roleAuthWrapper.eq("ROLE_ID", roleId);
            this.sysRoleAuthService.remove(roleAuthWrapper);

            // 【3】要删除子表数据--数据操作权限
            QueryWrapper<SysRoleData> roleDataWrapper = new QueryWrapper<>();
            roleDataWrapper.eq("ROLE_ID", roleId);
            this.sysRoleDataService.remove(roleDataWrapper);
            redisService.delKey(MyConstants.REDIS_SYS_ROLE_INFO + roleId);
        }
        sysCacheService.loadRoleToRedis();

    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

    /**
     * 【21】检查roleId是否存在
     *
     * @param roleId
     * @return
     */
    private boolean isExistRoleId(String roleId) {
        return this.getById(roleId) != null;
    }
}
