package com.gientech.sys.religion;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 宗教--的Mapper类
 *
 * @author 吴俊达
 */
@Mapper
public interface SysReligionMapper extends BaseMapper<SysReligion> {
    public List<SysReligionVO> getSysReligionList(Page<SysReligionVO> page, @Param("dto") SysReligionDTO4List dto);
}
