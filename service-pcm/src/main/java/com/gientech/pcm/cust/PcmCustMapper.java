package com.gientech.pcm.cust;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户--的Mapper类
 *
 * @author 吴俊达
 */
@Mapper
public interface PcmCustMapper  extends BaseMapper<PcmCust> {

    public List<PcmCustVO> getPcmCustList(Page<PcmCustVO> page, @Param("dto") PcmCustDTO4List dto);
}
