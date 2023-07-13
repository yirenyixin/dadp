package com.gientech.sys.config;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 系统参数--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysConfigMapper extends BaseMapper<SysConfig> {

	public List<SysConfigVO> getSysConfigList(Page<SysConfigVO> page, @Param("dto") SysConfigDTO4List dto);
}
