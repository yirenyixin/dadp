package com.gientech.pcm.prodOwn;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PCM_PROD_OWN Mapper 接口
 */
@Mapper
public interface PcmProdOwnMapper extends BaseMapper<PcmProdOwn> {

    List<PcmProdOwnVO> getPcmProdOwnList(Page<PcmProdOwnVO> page, @Param("dto") PcmProdOwnDTO4List dto);

    /**
     * 根据产品持有ID获取产品持有信息
     *
     * @param prodOwnId 产品持有ID
     * @return 产品持有信息
     */
    PcmProdOwn getPcmProdOwn(@Param("prodOwnId") String prodOwnId);
}