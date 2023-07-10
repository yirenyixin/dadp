package com.gientech.pcm.depFixed;//package com.gientech.sys.fixed;

import javax.validation.Valid;

import com.gientech.common.enums.OperType;
//import com.gientech.sys.depFixed.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gientech.common.Result;
import com.gientech.common.view.DataGrid;
import com.gientech.core.base.BaseController;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.security.annotation.PreAuthorize;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * PCM_DEP_FIXED 控制器
 */
@Api(tags = "【2-03】对私定期存款")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/pcm/depFixed")
public class PcmDepFixedController extends BaseController {

    @Autowired
    private PcmDepFixedService pcmDepFixedService;

    /**
     * 查询和分页
     *
     * @param pcmDepFixedDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "PCM_DEP_FIXED", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "pcmDepFixed")
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmDepFixedVO>> list(@Valid @RequestBody PcmDepFixedDTO4List pcmDepFixedDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmDepFixedService.listPcmDepFixed(pcmDepFixedDTO4List));
    }

    /**
     * 新增 PCM_DEP_FIXED
     *
     * @param pcmDepFixedDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增 PCM_DEP_FIXED")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "PCM_DEP_FIXED", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "pcmDepFixed")
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmDepFixedDTO4Save pcmDepFixedDTO4Save, BindingResult bindingResult) {
        this.pcmDepFixedService.savePcmDepFixed(pcmDepFixedDTO4Save);
        return Result.success();
    }

    /**
     * 修改 PCM_DEP_FIXED
     *
     * @param pcmDepFixedDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改 PCM_DEP_FIXED")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "PCM_DEP_FIXED", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "pcmDepFixed")
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmDepFixedDTO4Update pcmDepFixedDTO4Update, BindingResult bindingResult) {
        this.pcmDepFixedService.updatePcmDepFixed(pcmDepFixedDTO4Update);
        return Result.success();
    }

    /**
     * 删除 PCM_DEP_FIXED
     *
     * @param pcmDepFixedDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除 PCM_DEP_FIXED")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "PCM_DEP_FIXED", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "pcmDepFixed")
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmDepFixedDTO4Delete pcmDepFixedDTO4Delete, BindingResult bindingResult) {
        this.pcmDepFixedService.deletePcmDepFixed(pcmDepFixedDTO4Delete.getDepFixedIds());
        return Result.success();
    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}