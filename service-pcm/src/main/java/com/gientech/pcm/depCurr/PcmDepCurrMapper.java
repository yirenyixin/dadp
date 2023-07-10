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
     * 根据存款ID获取存款信息
     *
     * @param depCurrId 存款ID
     * @return 存款信息
     */
    PcmDepCurr getPcmDepCurr(@Param("depCurrId") String depCurrId);
}