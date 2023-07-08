package com.gientech.sys.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SYS_USER Mapper 接口
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

	List<SysUserVO> getSysUserList(Page<SysUserVO> page, @Param("dto") SysUserDTO4List dto);

	/**
	 * 根据用户ID获取用户信息
	 *
	 * @param userId 用户ID
	 * @return 用户信息
	 */
	SysUser getSysUser(@Param("userId") String userId);
}