package com.gientech.pcm.cust;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 客户--Service
 *
 * @author 吴俊达
 */
@Slf4j
@Service
@Transactional
public class PcmCustService extends BaseService<PcmCustMapper, PcmCust> {
    /**
     * 【1】新增--保存
     *
     * @param dto
     */
    public void saveCust(PcmCustDTO4Save dto) {
        log.info("【新增--客户】" + dto);

        // 【1】 从dto中copy属性
        PcmCust pcmCust = new PcmCust();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmCust);

        // 【2】 校验id是否存在
        if (isExistCustId(pcmCust.getCustId())) {
            throw new AppException("新增失败，客户ID【" + pcmCust.getCustId() + "】已经存在！");
        }

        this.save(pcmCust);
    }


    /**
     * 【2】删除--多个id以逗号分隔
     *
     * @param custIds
     */
    public void deleteCust(String custIds) {
        log.info("【删除--客户】" + custIds);

        // 【1】删除
        String[] custIdArray = StrUtil.splitToArray(custIds, ",");
        for (String custId : custIdArray) {
            this.removeById(custId);
        }
    }


    /**
     * 【3】修改
     *
     * @param pcmCust
     */
    public void updateCust(PcmCustDTO4Update dto) {
        log.info("【修改--客户】" + dto);

        // 【1】 从dto中copy属性
        PcmCust pcmCust = new PcmCust();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmCust);

//        // 【2】校验EcifCustId是否重复.
//        if (isExistEcifCustId(pcmCust)) {
//            throw new AppException("保存失败,EcifCustId【" + pcmCust.getEcifCustId() + "】已经存在!");
//        }

        if (!this.updateById(pcmCust)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 【4】查询和分页
     *
     * @param dto
     *
     * @return
     */
    public DataGrid<PcmCustVO> listCust(PcmCustDTO4List dto) {
        log.info("【查询条件--客户】" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "custName,custState,custType,certType,certNo,isEmployee");

        // 【2】构造分页参数
        Page<PcmCustVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<PcmCustVO>(this.getBaseMapper().getPcmCustList(page, dto), page.getTotal());
    }

    /**
     * 【5】查询分配客户
     *
     * @param dto
     *
     * @return
     */
    public DataGrid<PcmCustVO> listAssCust(PcmCustDTO4List dto) {
        log.info("【查询条件--客户】" + dto);

        // 【1】 处理模糊查询条件的like(有3个方法addObjectLike，addObjectLikeLeft，addObjectLikeRight)
        MyStringUtil.addObjectLike(dto, "custName,custState,custType,certType,certNo,isEmployee");

        // 【2】构造分页参数
        Page<PcmCustVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());

        return new DataGrid<PcmCustVO>(this.getBaseMapper().getPcmAssCustList(page, dto), page.getTotal());
    }






    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！Private方法放最底下】 *********************************************************************************************/

    /**
     * 【21】检查custId是否存在
     *
     * @param custId
     * @return
     */
    private boolean isExistCustId(String custId) {
        return this.getById(custId) != null;
    }

    /**
     * 【22】检查ecifCustId是否存在
     *
     * @param pcmCust
     * @return
     */
    private boolean isExistEcifCustId(PcmCust pcmCust){
        if (StringUtils.isEmpty(pcmCust.getCustId())) {
            QueryWrapper<PcmCust> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("ECIF_CUST_ID", pcmCust.getEcifCustId());
            return this.getOne(queryWrapper) != null;

        } else {
            QueryWrapper<PcmCust> queryWrapper = new QueryWrapper<>();
            queryWrapper.ne("CUST_ID", pcmCust.getCustId());
            queryWrapper.eq("ECIF_CUST_ID", pcmCust.getEcifCustId());
            return this.getOne(queryWrapper) != null;
        }
    }



}
