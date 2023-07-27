package com.gientech.sys.codeType;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 代码类别--的Mapper类
 * 
 * @author 胡砥峰
 */
@Mapper
public interface SysCodeTypeMapper extends BaseMapper<SysCodeType> {

	public List<SysCodeTypeVO> getSysCodeTypeList(Page<SysCodeTypeVO> page, @Param("dto") SysCodeTypeDTO4List dto);
}
