package com.gientech.sys.bookState;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 图书状态管理 - Mapper
 */
@Mapper
public interface SysBookStateMapper extends BaseMapper<SysBookState> {

    List<SysBookStateVO> getSysBookStateList(Page<SysBookStateVO> page, @Param("dto") SysBookStateDTO4List dto);

    SysBookStateVO getBookState(@Param("bookStateId") String bookStateId);
}
