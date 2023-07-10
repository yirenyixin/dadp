package com.gientech.pcm.depCurr;

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

@Slf4j
@Service
@Transactional
public class PcmDepCurrService extends BaseService<PcmDepCurrMapper, PcmDepCurr> {

    @Autowired
    private PcmDepCurrMapper pcmDepCurrMapper;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<PcmDepCurrVO> listPcmDepCurr(PcmDepCurrDTO4List dto) {
        log.info("【list查询条件--PCM_DEP_CURR】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "custName,custId");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "START_DT desc"));

        // 构造分页参数
        Page<PcmDepCurrVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getPcmDepCurrList(page, dto), page.getTotal());
    }

    /**
     * 新增 PCM_DEP_CURR
     *
     * @param dto 新增DTO
     */
    public void savePcmDepCurr(PcmDepCurrDTO4Save dto) {
        log.info("【新增--PCM_DEP_CURR】" + dto);

        // 从dto中复制属性
        PcmDepCurr pcmDepCurr = new PcmDepCurr();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmDepCurr);

        // 校验 depCurrId 是否存在
        if (isExistDepCurrId(pcmDepCurr.getDepCurrId())) {
            throw new AppException("新增失败，depCurrId【" + pcmDepCurr.getDepCurrId() + "】已经存在！");
        }

        this.save(pcmDepCurr);
    }

    /**
     * 修改 PCM_DEP_CURR
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updatePcmDepCurr(PcmDepCurrDTO4Update dto) {
        log.info("【修改--PCM_DEP_CURR】" + dto);

        // 从dto中复制属性
        PcmDepCurr pcmDepCurr = new PcmDepCurr();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmDepCurr);

        // 更新 PCM_DEP_CURR 信息
        if (!this.updateById(pcmDepCurr)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 删除 PCM_DEP_CURR
     *
     * @param depCurrIds 多个 depCurrId 以逗号分隔
     */
    public void deletePcmDepCurr(String depCurrIds) {
        log.info("【删除--PCM_DEP_CURR】" + depCurrIds);

        // 删除 PCM_DEP_CURR
        String[] depCurrIdArray = StrUtil.splitToArray(depCurrIds, ",");
        for (String depCurrId : depCurrIdArray) {
            this.removeById(depCurrId);
        }
    }

    /**
     * 检查 depCurrId 是否存在
     *
     * @param depCurrId depCurrId
     * @return 是否存在
     */
    private boolean isExistDepCurrId(String depCurrId) {
        QueryWrapper<PcmDepCurr> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("DEP_CURR_ID", depCurrId);
        return this.getOne(queryWrapper) != null;
    }
}