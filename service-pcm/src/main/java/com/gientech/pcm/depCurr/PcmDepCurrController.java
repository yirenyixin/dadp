package com.gientech.pcm.depCurr;

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
 * PcmDepCurr 控制器
 */
@Api(tags = "PCM_DEP_CURR")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/sys/depCurr")
public class PcmDepCurrController extends BaseController {

    @Autowired
    private PcmDepCurrService pcmDepCurrService;

    /**
     * 查询和分页
     *
     * @param pcmDepCurrDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "PCM_DEP_CURR", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "pcmDepCurr")
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmDepCurrVO>> list(@Valid @RequestBody PcmDepCurrDTO4List pcmDepCurrDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmDepCurrService.listPcmDepCurr(pcmDepCurrDTO4List));
    }

    /**
     * 新增 PCM_DEP_CURR
     *
     * @param pcmDepCurrDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增 PCM_DEP_CURR")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "PCM_DEP_CURR", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "pcmDepCurr")
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmDepCurrDTO4Save pcmDepCurrDTO4Save, BindingResult bindingResult) {
        this.pcmDepCurrService.savePcmDepCurr(pcmDepCurrDTO4Save);
        return Result.success();
    }

    /**
     * 修改 PCM_DEP_CURR
     *
     * @param pcmDepCurrDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改 PCM_DEP_CURR")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "PCM_DEP_CURR", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "pcmDepCurr")
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmDepCurrDTO4Update pcmDepCurrDTO4Update, BindingResult bindingResult) {
        this.pcmDepCurrService.updatePcmDepCurr(pcmDepCurrDTO4Update);
        return Result.success();
    }

    /**
     * 删除 PCM_DEP_CURR
     *
     * @param pcmDepCurrDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除 PCM_DEP_CURR")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "PCM_DEP_CURR", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "pcmDepCurr")
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmDepCurrDTO4Delete pcmDepCurrDTO4Delete, BindingResult bindingResult) {
        this.pcmDepCurrService.deletePcmDepCurr(pcmDepCurrDTO4Delete.getDepCurrIds());
        return Result.success();
    }

    /************* 【下面是新增的方法】 *********************************************************************************************/

    // TODO: 添加新的方法

}