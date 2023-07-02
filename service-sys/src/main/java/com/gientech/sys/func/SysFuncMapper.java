package com.gientech.sys.func;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 功能--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysFuncMapper extends BaseMapper<SysFunc> {

	public List<SysFuncVO> getSysFuncList(Page<SysFuncVO> page, @Param("dto") SysFuncDTO4List dto);
}
