package com.gientech.pmm.remind;

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
 * @date 2023/7/8 15:03
 */
@Api(tags = "【1-26】提醒表")
@ApiSort(value = 127)
@Validated
@RestController
@RequestMapping("/pmm/remind")
public class PmmRemindController extends BaseController {

    @Autowired
    private PmmRemindService pmmRemindService;

    /**
     * 查询和分页
     *
     * @param pmmRemindDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "提醒表", operType = OperType.SEARCH)
    //@PreAuthorize(hasAuth = "pmmRemind") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PmmRemindVO>> list(@Valid @RequestBody PmmRemindDTO4List pmmRemindDTO4List, BindingResult bindingResult){

        return Result.success(this.pmmRemindService.listRemind(pmmRemindDTO4List));

    }

//    /**
//     * 【2】新增后保存
//     *
//     * @param pmmRemindDTO4Save 新增DTO
//     * @param bindingResult
//     * @return
//     */
//    @ApiOperation(value = "新增后保存")
//    @ApiOperationSupport(order = 2)
//    @OperLog(title = "提醒表", operType = OperType.INSERT)
//    @PostMapping("/save")
//    public Result<Object> save(@Valid @RequestBody PmmRemindDTO4Save pmmRemindDTO4Save, BindingResult bindingResult){
//        this.pmmRemindService.saveRemind(pmmRemindDTO4Save);
//        return Result.success();
//    }
//
//    /**
//     * 【3】修改
//     *
//     * @param pmmRemindDTO4Update 修改DTO，一定要传主键
//     * @param bindingResult
//     * @return
//     */
//    @ApiOperation(value = "修改")
//    @ApiOperationSupport(order = 3)
//    @OperLog(title = "提醒表", operType = OperType.UPDATE)
//    @PostMapping("/update")
//    public Result<Object> update(@Valid @RequestBody PmmRemindDTO4Update pmmRemindDTO4Update, BindingResult bindingResult){
//        this.pmmRemindService.updateRemind(pmmRemindDTO4Update);
//        return Result.success();
//    }
//
    /**
     * 【4】删除--删除DTO
     *
     * @param pmmRemindDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "提醒表", operType = OperType.DELETE)
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PmmRemindDTO4Delete pmmRemindDTO4Delete, BindingResult bindingResult){
        this.pmmRemindService.deleteRemind(pmmRemindDTO4Delete.getRemindIds());
        return Result.success();
    }
}