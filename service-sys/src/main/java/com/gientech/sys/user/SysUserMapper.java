package com.gientech.sys.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 用户--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

	public List<SysUserVO> getSysUserList(Page<SysUserVO> page, @Param("dto") SysUserDTO4List dto);
}
