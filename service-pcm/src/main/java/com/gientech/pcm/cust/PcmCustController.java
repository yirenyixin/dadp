package com.gientech.pcm.cust;

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
 * 用户信息--Controller
 *
 * @author 吴俊达
 */
@Api(tags = "【2-01】客户信息")
@ApiSort(value = 201) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/pcm/cust")
public class PcmCustController extends BaseController {
    @Autowired
    private PcmCustService pcmCustService;

    /**
     * 【1】新增后保存
     *
     * @param pcmCustDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "客户", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "pcmCust") // 菜单id或功能id
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmCustDTO4Save pcmCustDTO4Save, BindingResult bindingResult) {
        this.pcmCustService.saveCust(pcmCustDTO4Save);
        return Result.success();
    }

    /**
     * 【2】删除
     *
     * @param pcmCustDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "客户", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "pcmCust") // 菜单id或功能id
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmCustDTO4Delete pcmCustDTO4Delete, BindingResult bindingResult) {
        this.pcmCustService.deleteCust(pcmCustDTO4Delete.getCustIds());
        return Result.success();
    }

    /**
     * 【3】修改
     *
     * @param pcmCustDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "客户", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "pcmCust") // 菜单id或功能id
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmCustDTO4Update pcmCustDTO4Update, BindingResult bindingResult) {
        this.pcmCustService.updateCust(pcmCustDTO4Update);
        return Result.success();
    }

    /**
     * 【4】查询和分页
     *
     * @param pcmCustDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "客户", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "pcmCust") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmCustVO>> list(@Valid @RequestBody PcmCustDTO4List pcmCustDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmCustService.listCust(pcmCustDTO4List));
    }
}
