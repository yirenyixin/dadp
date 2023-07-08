package com.gientech.pcm.depFixed;//package com.gientech.sys.fixed;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PCM_DEP_FIXED Mapper 接口
 */
@Mapper
public interface PcmDepFixedMapper extends BaseMapper<PcmDepFixed> {


    List<PcmDepFixedVO> getPcmDepFixedList(Page<PcmDepFixedVO> page, @Param("dto") PcmDepFixedDTO4List dto);
//    List<SysBookVO> getSysBookList(Page<SysBookVO> page, @Param("dto") SysBookDTO4List dto);
    /**
     * 根据存款ID获取存款信息
     *
     * @param depFixedId 存款ID
     * @return 存款信息
     */
    PcmDepFixed getPcmDepFixed(@Param("depFixedId") String depFixedId);
}