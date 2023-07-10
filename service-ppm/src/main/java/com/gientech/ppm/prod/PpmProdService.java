package com.gientech.ppm.prod;

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
public class PpmProdService extends BaseService<PpmProdMapper, PpmProd> {

    @Autowired
    private PpmProdMapper ppmProdMapper;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<PpmProdVO> listPpmProd(PpmProdDTO4List dto) {
        log.info("【list查询条件--PPM_PROD】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "prodName,kindId");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "PROD_ID asc"));

        // 构造分页参数
        Page<PpmProdVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<>(this.getBaseMapper().getPpmProdList(page, dto), page.getTotal());
    }

    /**
     * 新增 PPM_PROD
     *
     * @param dto 新增DTO
     */
    public void savePpmProd(PpmProdDTO4Save dto) {
        log.info("【新增--PPM_PROD】" + dto);

        // 从dto中复制属性
        PpmProd ppmProd = new PpmProd();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, ppmProd);

        // 校验 prodId 是否存在
        if (isExistProdId(ppmProd.getProdId())) {
            throw new AppException("新增失败，prodId【" + ppmProd.getProdId() + "】已经存在！");
        }

        this.save(ppmProd);
    }

    /**
     * 修改 PPM_PROD
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updatePpmProd(PpmProdDTO4Update dto) {
        log.info("【修改--PPM_PROD】" + dto);

        // 从dto中复制属性
        PpmProd ppmProd = new PpmProd();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, ppmProd);

        // 更新 PPM_PROD 信息
        if (!this.updateById(ppmProd)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 删除 PPM_PROD
     *
     * @param prodIds 多个 prodId 以逗号分隔
     */
    public void deletePpmProd(String prodIds) {
        log.info("【删除--PPM_PROD】" + prodIds);

        // 删除 PPM_PROD
        String[] prodIdArray = StrUtil.splitToArray(prodIds, ",");
        for (String prodId : prodIdArray) {
            this.removeById(prodId);
        }
    }

    /**
     * 检查 prodId 是否存在
     *
     * @param prodId prodId
     * @return 是否存在
     */
    private boolean isExistProdId(String prodId) {
        QueryWrapper<PpmProd> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("PROD_ID", prodId);
        return this.getOne(queryWrapper) != null;
    }
}