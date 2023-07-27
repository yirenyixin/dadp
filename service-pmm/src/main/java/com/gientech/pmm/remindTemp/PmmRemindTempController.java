package com.gientech.pmm.remindTemp;

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
 * @author cjm
 * @date 2023/7/8 17:08
 */
@Api(tags = "【1-25】事件参数管理")
@ApiSort(value = 126)
@Validated
@RestController
@RequestMapping("/pmm/remindTemp")
public class PmmRemindTempController extends BaseController {

    @Autowired
    private PmmRemindTempService pmmRemindTempService;

    /**
     * 查询和分页
     *
     * @param pmmRemindTempDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "事件参数管理", operType = OperType.SEARCH)
    //@PreAuthorize(hasAuth = "pmmRemindTemp") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PmmRemindTempVO>> list(@Valid @RequestBody PmmRemindTempDTO4List pmmRemindTempDTO4List, BindingResult bindingResult){

        return Result.success(this.pmmRemindTempService.listRemind(pmmRemindTempDTO4List));

    }

    /**
     * 【2】新增后保存
     *
     * @param pmmRemindTempDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "事件参数管理", operType = OperType.INSERT)
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PmmRemindTempDTO4Save pmmRemindTempDTO4Save, BindingResult bindingResult){

        this.pmmRemindTempService.saveRemindTemp(pmmRemindTempDTO4Save);
        return Result.success();
    }

    /**
     * 【3】修改
     *
     * @param pmmRemindTempDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "事件参数管理", operType = OperType.UPDATE)
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PmmRemindTempDTO4Update pmmRemindTempDTO4Update, BindingResult bindingResult){
        this.pmmRemindTempService.updateReminTemp(pmmRemindTempDTO4Update);
        return Result.success();
    }

    /**
     * 【4】删除--删除DTO
     *
     * @param pmmRemindTempDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "事件参数管理", operType = OperType.DELETE)
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PmmRemindTempDTO4Delete pmmRemindTempDTO4Delete, BindingResult bindingResult){
        this.pmmRemindTempService.deleteRemindTemp(pmmRemindTempDTO4Delete.getRemindTempIds());
        return Result.success();
    }
}