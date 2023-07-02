package com.gientech.sys.book;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 图书管理 - Mapper
 */
@Mapper
public interface SysBookMapper extends BaseMapper<SysBook> {

    List<SysBookVO> getSysBookList(Page<SysBookVO> page, @Param("dto") SysBookDTO4List dto);

    SysBookVO getBook(@Param("bookId") String bookId);
}