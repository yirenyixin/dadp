package com.gientech.pcm.prodOwn;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import com.gientech.pcm.loan.PcmLoan;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
public class PcmProdOwnService extends BaseService<PcmProdOwnMapper, PcmProdOwn> {

    @Autowired
    private PcmProdOwnMapper pcmProdOwnMapper;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<PcmProdOwnVO> listPcmProdOwn(PcmProdOwnDTO4List dto) {
        log.info("【list查询条件--PCM_PROD_OWN】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "custId,lawOrgId,ecifCustId");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), ""));

        // 构造分页参数
        Page<PcmProdOwnVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getPcmProdOwnList(page, dto), page.getTotal());
    }

    /**
     * 新增 PCM_PROD_OWN
     *
     * @param dto 新增DTO
     */
    public void savePcmProdOwn(PcmProdOwnDTO4Save dto) {
        log.info("【新增--PCM_PROD_OWN】" + dto);

        // 从dto中复制属性
        PcmProdOwn pcmProdOwn = new PcmProdOwn();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmProdOwn);

        // 校验 prodOwnId 是否存在
        if (isExistProdOwnId(pcmProdOwn.getProdOwnId())) {
            throw new AppException("新增失败，prodOwnId【" + pcmProdOwn.getProdOwnId() + "】已经存在！");
        }

        this.save(pcmProdOwn);
    }

    /**
     * 修改 PCM_PROD_OWN
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updatePcmProdOwn(PcmProdOwnDTO4Update dto) {
        log.info("【修改--PCM_PROD_OWN】" + dto);

        // 从dto中复制属性
        PcmProdOwn pcmProdOwn = new PcmProdOwn();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmProdOwn);

        // 更新 PCM_PROD_OWN 信息
        if (!this.updateById(pcmProdOwn)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 删除 PCM_PROD_OWN
     *
     * @param prodOwnIds 多个 prodOwnId 以逗号分隔
     */
    public void deletePcmProdOwn(String prodOwnIds) {
        log.info("【删除--PCM_PROD_OWN】" + prodOwnIds);

        // 删除 PCM_PROD_OWN
        String[] prodOwnIdArray = StrUtil.splitToArray(prodOwnIds, ",");
        for (String prodOwnId : prodOwnIdArray) {
            this.removeById(prodOwnId);
        }

    }

    /**
     * 检查 prodOwnId 是否存在
     *
     * @param prodOwnId prodOwnId
     * @return 是否存在
     */
    private boolean isExistProdOwnId(String prodOwnId) {
        QueryWrapper<PcmProdOwn> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PROD_OWN_ID", prodOwnId);
        return this.getOne(queryWrapper) != null;
    }
}