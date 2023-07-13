package com.gientech.sys.codeInfo;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码信息--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysCodeInfoMapper extends BaseMapper<SysCodeInfo> {

	public List<SysCodeInfoVO> getSysCodeInfoList(Page<SysCodeInfoVO> page, @Param("dto") SysCodeInfoDTO4List dto);
}
