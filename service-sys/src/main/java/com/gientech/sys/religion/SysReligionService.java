package com.gientech.sys.religion;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.core.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 宗教--Service
 *
 * @author 吴俊达
 */

@Slf4j
@Service
@Transactional
public class SysReligionService extends BaseService<SysReligionMapper, SysReligion> {
    @Autowired
    RedisService redisService;

    /**
     * 【1】新增--保存
     *
     * @param dto
     */
    public void saveOrg(SysReligionDTO4Save dto) {
        log.info("【新增--机构】" + dto);

        // 【1】 从dto中copy属性
        SysReligion sysReligion = new SysReligion();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysReligion);

        // 【2】 校验id是否存在
        if (isExistReligionId(sysReligion.getReligionId())) {
            throw new AppException("新增失败，宗教ID【" + sysReligion.getReligionId() + "】已经存在！");
        }

        sysReligion.setVer(1);// 数据版本
        this.save(sysReligion);
    }

    /**
     * 【2】删除
     *
     * @param religionIds
     */
    public void deleteReligion(String religionIds) {
        log.info("【删除--宗教】" + religionIds);
        // 【1】删除
        String[] religionIdArray = StrUtil.splitToArray(religionIds, ",");
        for (String religionId : religionIdArray) {
            this.removeById(religionId);
        }
    }


    /**
     * 【3】修改
     *
     * @param sysReligion
     */
    public void updateReligion(SysReligionDTO4Update dto) {
        log.info("【修改--宗教】" + dto);

        // 【1】 从dto中copy属性
        SysReligion sysReligion = new SysReligion();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, sysReligion);

        // 【2】校验ReligionName是否重复.
        if (isExistReligionName(sysReligion)) {
            throw new AppException("保存失败,宗教名称【" + sysReligion.getReligionName() + "】已经存在!");
        }

        if (!this.updateById(sysReligion)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 【4】根据Id获取对象
     *
     * @param religionId 主键ID
     * @return
     * @throws AppException
     */
    public SysReligion getReligion(String religionId) throws AppException {
        log.info("【获取单个--宗教】" + religionId);
        return this.getById(religionId);
    }


    /**
     * 【5】查询和分页
     *
     * @param dto
     *
     * @return
     */
    public DataGrid<SysReligionVO> listReligion(SysReligionDTO4List dto) {
        log.info("【查询条件--宗教】" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "religionId,religionName");

        // 【2】处理前端传入排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "SORT_NO asc, RELIGION_ID asc"));

        // 【3】构造分页参数
        Page<SysReligionVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<SysReligionVO>(this.getBaseMapper().getSysReligionList(page, dto), page.getTotal());
    }




    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/


    /**
     * 【21】检查ReligionId是否存在
     *
     * @param religionId
     * @return
     */
    private boolean isExistReligionId(String religionId) {
        return this.getById(religionId) != null;
    }


    private boolean isExistReligionName(SysReligion sysReligion){
        if (StringUtils.isEmpty(sysReligion.getReligionId())) {
            QueryWrapper<SysReligion> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("RELIGION_NAME", sysReligion.getReligionName());
            return this.getOne(queryWrapper) != null;

        } else {
            QueryWrapper<SysReligion> queryWrapper = new QueryWrapper<>();
            queryWrapper.ne("RELIGION_ID", sysReligion.getReligionId());
            queryWrapper.eq("RELIGION_NAME", sysReligion.getReligionName());
            return this.getOne(queryWrapper) != null;
        }
    }

}


