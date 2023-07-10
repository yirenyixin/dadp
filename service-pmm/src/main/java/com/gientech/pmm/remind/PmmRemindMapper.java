package com.gientech.pmm.remind;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cjm
 * @date 2023/7/8 15:03
 */
@Mapper
public interface PmmRemindMapper extends BaseMapper<PmmRemind> {

    public List<PmmRemindVO> getPmmRemindList(Page<PmmRemindVO> page, @Param("dto") PmmRemindDTO4List dto);
}
