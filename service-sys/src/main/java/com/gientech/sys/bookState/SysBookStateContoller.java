package com.gientech.sys.bookState;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

/**
 * 图书状态管理--Controller
 *
 * TODO: 添加适当的标签和排序值
 */
@Api(tags = "【TODO】图书状态管理")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/sys/book-state")
public class SysBookStateContoller extends BaseController {

    @Autowired
    private SysBookStateService sysBookStateService;

    /**
     * 查询和分页
     *
     * @param sysBookStateDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "图书状态", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "sysBookState") // TODO: 添加适当的权限标识符
    @PostMapping(value = "/list")
    public Result<DataGrid<SysBookStateVO>> list(@Valid @RequestBody SysBookStateDTO4List sysBookStateDTO4List, BindingResult bindingResult) {

        return Result.success(this.sysBookStateService.listBookStates(sysBookStateDTO4List));
    }

    /**
     * 新增图书状态
     *
     * @param sysBookStateDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增图书状态")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "图书状态", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "sysBookState") // TODO: 添加适当的权限标识符
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody SysBookStateDTO4Save sysBookStateDTO4Save, BindingResult bindingResult) {
        this.sysBookStateService.saveBookState(sysBookStateDTO4Save);
        return Result.success();
    }

    /**
     * 修改图书状态
     *
     * @param sysBookStateDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改图书状态")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "图书状态", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "sysBookState") // TODO: 添加适当的权限标识符
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody SysBookStateDTO4Update sysBookStateDTO4Update, BindingResult bindingResult) {
        this.sysBookStateService.updateBookState(sysBookStateDTO4Update);
        return Result.success();
    }

    /**
     * 删除图书状态
     *
     * @param sysBookStateDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除图书状态")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "图书状态", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "sysBookState") // TODO: 添加适当的权限标识符
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody SysBookStateDTO4Delete sysBookStateDTO4Delete, BindingResult bindingResult) {
        this.sysBookStateService.deleteBookState(sysBookStateDTO4Delete.getBookIds());
        return Result.success();
    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
