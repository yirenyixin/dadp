package com.gientech.pcm.depCurr;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PCM_DEP_CURR Mapper 接口
 */
@Mapper
public interface PcmDepCurrMapper extends BaseMapper<PcmDepCurr> {

    List<PcmDepCurrVO> getPcmDepCurrList(Page<PcmDepCurrVO> page, @Param("dto") PcmDepCurrDTO4List dto);

    /**
     * 根据账户ID获取账户信息
     *
     * @param depCurrId 账户ID
     * @return 账户信息
     */
    PcmDepCurr getPcmDepCurr(@Param("depCurrId") String depCurrId);
}