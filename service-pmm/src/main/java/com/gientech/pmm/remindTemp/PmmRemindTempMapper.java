package com.gientech.pmm.remindTemp;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cjm
 * @date 2023/7/7 23:49
 */
@Mapper
public interface PmmRemindTempMapper extends BaseMapper<PmmRemindTemp> {

    public List<PmmRemindTempVO> getPmmRemindTempList(Page<PmmRemindTempVO> page, @Param("dto") PmmRemindTempDTO4List dto);

}
