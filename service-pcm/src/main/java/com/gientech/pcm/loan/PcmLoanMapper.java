package com.gientech.pcm.loan;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * PCM_LOAN Mapper 接口
 */
@Mapper
public interface PcmLoanMapper extends BaseMapper<PcmLoan> {

    List<PcmLoanVO> getPcmLoanList(Page<PcmLoanVO> page, @Param("dto") PcmLoanDTO4List dto);

    /**
     * 根据贷款ID获取贷款信息
     *
     * @param loanId 贷款ID
     * @return 贷款信息
     */
    PcmLoan getPcmLoan(@Param("loanId") String loanId);
}
