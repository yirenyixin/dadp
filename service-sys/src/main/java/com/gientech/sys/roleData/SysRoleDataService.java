package com.gientech.sys.roleData;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.MyConstants;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 数据权限--Service
 *
 * @author 胡砥峰
 */
@Slf4j
@Service
@Transactional
public class SysRoleDataService extends BaseService<SysRoleDataMapper, SysRoleData> {

    @Autowired
    private RedisService redisService;

    /**
     * 【1】查询和分页
     *
     * @param dto
     * @return
     */
    public DataGrid<SysRoleDataVO> listRoleData(SysRoleDataDTO4List dto) {
        log.info("【list查询条件--数据权限】" + dto);

        // 【2】构造分页参数
        Page<SysRoleDataVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<SysRoleDataVO>(this.getBaseMapper().getSysRoleDataList(page, dto), page.getTotal());
    }

    /**
     * 【2】新增--保存
     *
     * @param dto
     */
    public void saveRoleData(SysRoleDataDTO4Save dto) {
        log.info("【新增--数据权限】" + dto);

        // 【1】 从dto中copy属性
        SysRoleData sysRoleData = new SysRoleData();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysRoleData);

        sysRoleData.setVer(1);// 数据版本
        this.save(sysRoleData);

        // 【2】更新缓存
        updateRedis(sysRoleData);
    }

    /**
     * 【3】修改
     *
     * @param dto
     */
    public void updateRoleData(SysRoleDataDTO4Update dto) {
        log.info("【修改--数据权限】" + dto);

        // 【1】 从dto中copy属性
        SysRoleData sysRoleData = new SysRoleData();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysRoleData);

        if (!this.updateById(sysRoleData)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
        // 【2】更新缓存
        updateRedis(sysRoleData);
    }

    /**
     * 【4】删除--多个id以逗号分隔
     *
     * @param roleDataIds
     */
    public void deleteRoleData(String roleDataIds) {
        log.info("【删除--数据权限】" + roleDataIds);

        // 【1】删除
        String[] roleDataIdArray = StrUtil.splitToArray(roleDataIds, ",");
        for (String roleDataId : roleDataIdArray) {
            // 【2】读取对象，获取codeTypeId
            SysRoleData sysRoleData = this.getById(roleDataId);
            this.removeById(roleDataId);
            // 【3】更新缓存
            updateRedis(sysRoleData);
        }

    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

    public List<SysRoleData> getRoleDataListByRoleId(String roleId) {
        // 【1】查询SysRoleData
        QueryWrapper<SysRoleData> queryWrapper = new QueryWrapper<SysRoleData>();
        queryWrapper.eq("ROLE_ID", roleId);

        return this.list(queryWrapper);
    }

    /**
     * 更新redis数据
     *
     * @param sysRoleData
     */
    private void updateRedis(SysRoleData sysRoleData) {
        redisService.set(MyConstants.REDIS_SYS_ROLE + sysRoleData.getRoleId(), getRoleDataListByRoleId(sysRoleData.getRoleId()));
    }
}
