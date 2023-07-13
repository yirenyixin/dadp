package com.gientech.sys.func;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 功能--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysFuncMapper extends BaseMapper<SysFunc> {

	public List<SysFuncVO> getSysFuncList(Page<SysFuncVO> page, @Param("dto") SysFuncDTO4List dto);
}
