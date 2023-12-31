package com.gientech.pcm.prodOwn;

import com.gientech.common.Result;
import com.gientech.common.enums.OperType;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseController;
import com.gientech.core.log.annotation.OperLog;
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
 * PcmProdOwn 控制器
 */
@Api(tags = "PCM_PROD_OWN")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/pcm/prodOwn")
public class PcmProdOwnController extends BaseController {

    @Autowired
    private PcmProdOwnService pcmProdOwnService;

    /**
     * 查询和分页
     *
     * @param pcmProdOwnDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "PCM_PROD_OWN", operType = OperType.SEARCH)
//    @PreAuthorize(hasAuth = "PCMProdOwn")
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmProdOwnVO>> list(@Valid @RequestBody PcmProdOwnDTO4List pcmProdOwnDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmProdOwnService.listPcmProdOwn(pcmProdOwnDTO4List));
    }

    /**
     * 新增 PCM_PROD_OWN
     *
     * @param pcmProdOwnDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增 PCM_PROD_OWN")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "PCM_PROD_OWN", operType = OperType.INSERT)
//    @PreAuthorize(hasAuth = "PCMProdOwn")
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmProdOwnDTO4Save pcmProdOwnDTO4Save, BindingResult bindingResult) {
        this.pcmProdOwnService.savePcmProdOwn(pcmProdOwnDTO4Save);
        return Result.success();
    }

    /**
     * 修改 PCM_PROD_OWN
     *
     * @param pcmProdOwnDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改 PCM_PROD_OWN")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "PCM_PROD_OWN", operType = OperType.UPDATE)
//    @PreAuthorize(hasAuth = "PCMProdOwn")
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmProdOwnDTO4Update pcmProdOwnDTO4Update, BindingResult bindingResult) {
        this.pcmProdOwnService.updatePcmProdOwn(pcmProdOwnDTO4Update);
        return Result.success();
    }

    /**
     * 删除 PCM_PROD_OWN
     *
     * @param pcmProdOwnDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除 PCM_PROD_OWN")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "PCM_PROD_OWN", operType = OperType.DELETE)
//    @PreAuthorize(hasAuth = "PCMProdOwn")
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmProdOwnDTO4Delete pcmProdOwnDTO4Delete, BindingResult bindingResult) {
        this.pcmProdOwnService.deletePcmProdOwn(pcmProdOwnDTO4Delete.getProdOwnIds());
        return Result.success();
    }

    // TODO: 添加新的方法

}