package com.gientech.pcm.prodOwn;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PcmProdOwn Mapper 接口
 */
@Mapper
public interface PcmProdOwnMapper extends BaseMapper<PcmProdOwn> {

    /**
     * 分页查询 PcmProdOwn 列表
     *
     * @param page 分页对象
     * @param dto  查询条件
     * @return PcmProdOwn 列表
     */
    List<PcmProdOwnVO> getPcmProdOwnList(Page<PcmProdOwnVO> page, @Param("dto") PcmProdOwnDTO4List dto);

    /**
     * 根据 prodOwnId 获取 PcmProdOwn 信息
     *
     * @param prodOwnId prodOwnId
     * @return PcmProdOwn 信息
     */
    PcmProdOwn getPcmProdOwn(@Param("prodOwnId") String prodOwnId);
}