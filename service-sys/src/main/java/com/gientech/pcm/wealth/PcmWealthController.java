package com.gientech.pcm.wealth;

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
 * @date 2023/7/7 20:59
 */
@Api(tags = "【1-24】对私理财")
@ApiSort(value = 125) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/pcm/wealth")
public class PcmWealthController extends BaseController {

    @Autowired
    private PcmWealthService pcmWealthService;

    /**
     * 【1】查询和分页
     *
     * @param pcmWealthDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "对私理财", operType = OperType.SEARCH)
    //@PreAuthorize(hasAuth = "pcmWealth") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmWealthVO>> list(@Valid @RequestBody PcmWealthDTO4List pcmWealthDTO4List, BindingResult bindingResult) {

        return Result.success(this.pcmWealthService.listWealth(pcmWealthDTO4List));
    }

    /**
     * 【2】新增后保存
     *
     * @param pcmWealthDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "对私理财", operType = OperType.INSERT)
    //@PreAuthorize(hasAuth = "sysWealth") // 菜单id或功能id
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmWealthDTO4Save pcmWealthDTO4Save, BindingResult bindingResult){
        this.pcmWealthService.saveWealth(pcmWealthDTO4Save);
        return Result.success();
    }

    /**
     * 【3】修改
     *
     * @param pcmWealthDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "对私理财", operType = OperType.UPDATE)
    //@PreAuthorize(hasAuth = "pcmWealth") // 菜单id或功能id
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmWealthDTO4Update pcmWealthDTO4Update, BindingResult bindingResult) {
        this.pcmWealthService.updateWealth(pcmWealthDTO4Update);
        return Result.success();
    }

    /**
     * 【4】删除--删除DTO
     *
     * @param pcmWealthDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "对私理财", operType = OperType.DELETE)
    //@PreAuthorize(hasAuth = "pcmWealth") // 菜单id或功能id
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmWealthDTO4Delete pcmWealthDTO4Delete, BindingResult bindingResult) {
        this.pcmWealthService.deleteWealth(pcmWealthDTO4Delete.getIds());
        return Result.success();
    }

}