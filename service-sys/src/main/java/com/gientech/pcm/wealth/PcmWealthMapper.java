package com.gientech.pcm.wealth;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cjm
 * @date 2023/7/7 19:24
 */
@Mapper
public interface PcmWealthMapper extends BaseMapper<PcmWealth> {

    public List<PcmWealthVO> getPcmWealthList(Page<PcmWealthVO> page, @Param("dto") PcmWealthDTO4List dto);

}
