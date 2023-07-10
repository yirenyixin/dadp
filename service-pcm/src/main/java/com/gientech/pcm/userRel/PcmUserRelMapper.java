package com.gientech.pcm.userRel;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 机构归属关系--的Mapper类
 *
 * @author 吴俊达
 */
@Mapper
public interface PcmUserRelMapper extends BaseMapper<PcmUserRel> {
    public List<PcmUserRelVO> getPcmUserRelList(Page<PcmUserRelVO> page, @Param("dto") PcmUserRelDTO4List dto);
}
