package com.gientech.sys.roleData;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 数据权限--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysRoleDataMapper extends BaseMapper<SysRoleData> {

	public List<SysRoleDataVO> getSysRoleDataList(Page<SysRoleDataVO> page, @Param("dto") SysRoleDataDTO4List dto);
}
