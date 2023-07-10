package com.gientech.pcm.orgRel;

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
public interface PcmOrgRelMapper extends BaseMapper<PcmOrgRel> {
    public List<PcmOrgRelVO> getPcmOrgRelList(Page<PcmOrgRelVO> page, @Param("dto") PcmOrgRelDTO4List dto);
}
