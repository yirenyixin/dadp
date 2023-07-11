package com.gientech.ppm.prod;

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
 * PpmProd 控制器
 */
@Api(tags = "【4-01】产品表")
@ApiSort(value = 401)
@Validated
@RestController
@RequestMapping("/ppm/prod")
public class PpmProdController extends BaseController {

    @Autowired
    private PpmProdService ppmProdService;

    /**
     * 查询和分页
     *
     * @param ppmProdDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "PPM_PROD", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "ppmProd")
    @PostMapping(value = "/list")
    public Result<DataGrid<PpmProdVO>> list(@Valid @RequestBody PpmProdDTO4List ppmProdDTO4List, BindingResult bindingResult) {
        return Result.success(this.ppmProdService.listPpmProd(ppmProdDTO4List));
    }

    /**
     * 新增 PPM_PROD
     *
     * @param ppmProdDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增 PPM_PROD")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "PPM_PROD", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "ppmProd")
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PpmProdDTO4Save ppmProdDTO4Save, BindingResult bindingResult) {
        this.ppmProdService.savePpmProd(ppmProdDTO4Save);
        return Result.success();
    }

    /**
     * 修改 PPM_PROD
     *
     * @param ppmProdDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改 PPM_PROD")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "PPM_PROD", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "ppmProd")
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PpmProdDTO4Update ppmProdDTO4Update, BindingResult bindingResult) {
        this.ppmProdService.updatePpmProd(ppmProdDTO4Update);
        return Result.success();
    }

    /**
     * 删除 PPM_PROD
     *
     * @param ppmProdDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除 PPM_PROD")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "PPM_PROD", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "ppmProd")
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PpmProdDTO4Delete ppmProdDTO4Delete, BindingResult bindingResult) {
        this.ppmProdService.deletePpmProd(ppmProdDTO4Delete.getProdIds());
        return Result.success();
    }

    // TODO: 添加新的方法

}