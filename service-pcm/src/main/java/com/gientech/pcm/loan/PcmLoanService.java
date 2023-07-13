package com.gientech.pcm.loan;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gientech.common.exception.AppException;
import com.gientech.common.util.MyBeanUtil;
import com.gientech.common.util.MyStringUtil;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Service
@Transactional
public class PcmLoanService extends BaseService<PcmLoanMapper, PcmLoan> {

    @Autowired
    private PcmLoanMapper pcmLoanMapper;

    /**
     * 查询和分页
     *
     * @param dto 查询DTO
     * @return 分页结果
     */
    public DataGrid<PcmLoanVO> listPcmLoan(PcmLoanDTO4List dto) {
        log.info("【list查询条件--PCM_LOAN】" + dto);

        // 处理模糊查询条件的like
        MyStringUtil.addObjectLike(dto, "custName,custId");

        // 处理排序条件
        dto.setOrderBy(MyStringUtil.getOrderBy(dto.getSort(), dto.getOrder(), "START_DATE desc"));

        // 构造分页参数
        Page<PcmLoanVO> page = new Page<>(dto.getPageNo(), dto.getPageSize());


        SimpleDateFormat formatter= new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(System.currentTimeMillis());
        dto.setNowDate(formatter.format(date));

        return new DataGrid<>(this.getBaseMapper().getPcmLoanList(page, dto), page.getTotal());
    }

    /**
     * 新增 PCM_LOAN
     *
     * @param dto 新增DTO
     */
    public void savePcmLoan(PcmLoanDTO4Save dto) {
        log.info("【新增--PCM_LOAN】" + dto);

        // 从dto中复制属性
        PcmLoan pcmLoan = new PcmLoan();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmLoan);

        // 校验 loanId 是否存在
        if (isExistLoanId(pcmLoan.getLoanId())) {
            throw new AppException("新增失败，loanId【" + pcmLoan.getLoanId() + "】已经存在！");
        }

        this.save(pcmLoan);
    }

    /**
     * 修改 PCM_LOAN
     *
     * @param dto 修改DTO，一定要传主键
     */
    public void updatePcmLoan(PcmLoanDTO4Update dto) {
        log.info("【修改--PCM_LOAN】" + dto);

        // 从dto中复制属性
        PcmLoan pcmLoan = new PcmLoan();
        MyBeanUtil.copyPropertiesIgnoreNull(dto, pcmLoan);

        // 更新 PCM_LOAN 信息
        if (!this.updateById(pcmLoan)) {
            throw new AppException("操作失败，你修改的数据不是最新的，请刷新后重新操作！");
        }
    }

    /**
     * 删除 PCM_LOAN
     *
     * @param loanIds 多个 loanId 以逗号分隔
     */
    public void deletePcmLoan(String loanIds) {
        log.info("【删除--PCM_LOAN】" + loanIds);

        // 删除 PCM_LOAN
        String[] loanIdArray = StrUtil.splitToArray(loanIds, ",");
        for (String loanId : loanIdArray) {
            this.removeById(loanId);
        }
    }

    /**
     * 检查 loanId 是否存在
     *
     * @param loanId loanId
     * @return 是否存在
     */
    private boolean isExistLoanId(String loanId) {
        QueryWrapper<PcmLoan> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("LOAN_ID", loanId);
        return this.getOne(queryWrapper) != null;
    }
}
