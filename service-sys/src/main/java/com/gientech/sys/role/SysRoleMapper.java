package com.gientech.sys.role;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色--的Mapper类
 *
 * @author 胡砥峰
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {

    List<SysRoleVO> getSysRoleList(Page<SysRoleVO> page, @Param("dto") SysRoleDTO4List dto);

    SysRoleVO getRole(@Param("roleId") String roleId);
}
