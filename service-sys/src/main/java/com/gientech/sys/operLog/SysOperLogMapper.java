package com.gientech.sys.operLog;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 操作日志--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

	public List<SysOperLogVO> getSysOperLogList(Page<SysOperLogVO> page, @Param("dto") SysOperLogDTO4List dto);
}
