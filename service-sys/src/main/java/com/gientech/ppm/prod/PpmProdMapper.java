package com.gientech.ppm.prod;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PPM_PROD Mapper 接口
 */
@Mapper
public interface PpmProdMapper extends BaseMapper<PpmProd> {

    List<PpmProdVO> getPpmProdList(Page<PpmProdVO> page, @Param("dto") PpmProdDTO4List dto);

    /**
     * 根据产品ID获取产品信息
     *
     * @param prodId 产品ID
     * @return 产品信息
     */
    PpmProd getPpmProd(@Param("prodId") String prodId);
}