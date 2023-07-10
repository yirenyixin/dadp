//package com.gientech.sys.fixed;
package com.gientech.pcm.depFixed;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * PCM_DEP_FIXED 服务类
 */
@Slf4j
@Service
@Transactional
public class PcmDepFixedService extends BaseService<PcmDepFixedMapper, PcmDepFixed> {

    @Autowired
    private PcmDepFixedMapper pcmDepFixedMapper;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<PcmDepFixedVO> listPcmDepFixed(PcmDepFixedDTO4List dto) {
        log.info("【list查询条件--PCM_DEP_FIXED】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "custName,custId");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "START_DT desc"));

        // 构造分页参数
        Page<PcmDepFixedVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getPcmDepFixedList(page, dto), page.getTotal());

//        return new DataGrid<>(this.getBaseMapper().getSysBookList(page, dto), page.getTotal());
    }

    /**
     * 新增 PCM_DEP_FIXED
     *
     * @param dto 新增DTO
     */
    public void savePcmDepFixed(PcmDepFixedDTO4Save dto) {
        log.info("【新增--PCM_DEP_FIXED】" + dto);

        // 从dto中复制属性
        PcmDepFixed pcmDepFixed = new PcmDepFixed();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmDepFixed);

        // 校验 depFixedId 是否存在
        if (isExistDepFixedId(pcmDepFixed.getDepFixedId())) {
            throw new AppException("新增失败，depFixedId【" + pcmDepFixed.getDepFixedId() + "】已经存在！");
        }

        this.save(pcmDepFixed);
    }

    /**
     * 修改 PCM_DEP_FIXED
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updatePcmDepFixed(PcmDepFixedDTO4Update dto) {
        log.info("【修改--PCM_DEP_FIXED】" + dto);

        // 从dto中复制属性
        PcmDepFixed pcmDepFixed = new PcmDepFixed();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmDepFixed);

        // 更新 PCM_DEP_FIXED 信息
        if (!this.updateById(pcmDepFixed)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 删除 PCM_DEP_FIXED
     *
     * @param depFixedIds 多个 depFixedId 以逗号分隔
     */
    public void deletePcmDepFixed(String depFixedIds) {
        log.info("【删除--PCM_DEP_FIXED】" + depFixedIds);

        // 删除 PCM_DEP_FIXED
        String[] depFixedIdArray = StrUtil.splitToArray(depFixedIds, ",");
        for (String depFixedId : depFixedIdArray) {
            this.removeById(depFixedId);
        }
    }

    /**
     * 检查 depFixedId 是否存在
     *
     * @param depFixedId depFixedId
     * @return 是否存在
     */
    private boolean isExistDepFixedId(String depFixedId) {
        QueryWrapper<PcmDepFixed> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DEP_FIXED_ID", depFixedId);
        return this.getOne(queryWrapper) != null;
    }
}