package com.gientech.pcm.loan;

import com.gientech.common.Result;
import com.gientech.common.enums.OperType;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseController;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.security.annotation.PreAuthorize;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * PcmLoan 控制器
 */
@Api(tags = "PCM_LOAN")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/sys/loan")
public class PcmLoanController extends BaseController {

    @Autowired
    private PcmLoanService pcmLoanService;

    /**
     * 查询和分页
     *
     * @param pcmLoanDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "PCM_LOAN", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "pcmLoan")
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmLoanVO>> list(@Valid @RequestBody PcmLoanDTO4List pcmLoanDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmLoanService.listPcmLoan(pcmLoanDTO4List));
    }

    /**
     * 新增 PCM_LOAN
     *
     * @param pcmLoanDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增 PCM_LOAN")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "PCM_LOAN", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "pcmLoan")
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmLoanDTO4Save pcmLoanDTO4Save, BindingResult bindingResult) {
        this.pcmLoanService.savePcmLoan(pcmLoanDTO4Save);
        return Result.success();
    }

    /**
     * 修改 PCM_LOAN
     *
     * @param pcmLoanDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改 PCM_LOAN")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "PCM_LOAN", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "pcmLoan")
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmLoanDTO4Update pcmLoanDTO4Update, BindingResult bindingResult) {
        this.pcmLoanService.updatePcmLoan(pcmLoanDTO4Update);
        return Result.success();
    }

    /**
     * 删除 PCM_LOAN
     *
     * @param pcmLoanDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除 PCM_LOAN")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "PCM_LOAN", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "pcmLoan")
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmLoanDTO4Delete pcmLoanDTO4Delete, BindingResult bindingResult) {
        this.pcmLoanService.deletePcmLoan(pcmLoanDTO4Delete.getLoanIds());
        return Result.success();
    }

    /************* 【下面是新增的方法】 *********************************************************************************************/

    // TODO: 添加新的方法

}