package com.gientech.sys.log;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 登录日志--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLog> {

	public List<SysLogVO> getSysLogList(Page<SysLogVO> page, @Param("dto") SysLogDTO4List dto);
}
