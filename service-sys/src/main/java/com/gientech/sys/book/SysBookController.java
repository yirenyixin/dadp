package com.gientech.sys.book;

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
 * 图书管理--Controller
 *
 * TODO: 添加适当的标签和排序值
 */
@Api(tags = "【TODO】图书管理")
@ApiSort(value = 0)
@Validated
@RestController
@RequestMapping("/sys/book")
public class SysBookController extends BaseController {

    @Autowired
    private SysBookService sysBookService;

    /**
     * 查询和分页
     *
     * @param sysBookDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "图书", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "sysBook") // TODO: 添加适当的权限标识符
    @PostMapping(value = "/list")
    public Result<DataGrid<SysBookVO>> list(@Valid @RequestBody SysBookDTO4List sysBookDTO4List, BindingResult bindingResult) {

        return Result.success(this.sysBookService.listBooks(sysBookDTO4List));
    }

    /**
     * 新增图书
     *
     * @param sysBookDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增图书")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "图书", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "sysBook") // TODO: 添加适当的权限标识符
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody SysBookDTO4Save sysBookDTO4Save, BindingResult bindingResult) {
        this.sysBookService.saveBook(sysBookDTO4Save);
        return Result.success();
    }

    /**
     * 修改图书
     *
     * @param sysBookDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改图书")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "图书", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "sysBook") // TODO: 添加适当的权限标识符
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody SysBookDTO4Update sysBookDTO4Update, BindingResult bindingResult) {
        this.sysBookService.updateBook(sysBookDTO4Update);
        return Result.success();
    }

    /**
     * 删除图书
     *
     * @param sysBookDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除图书")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "图书", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "sysBook") // TODO: 添加适当的权限标识符
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody SysBookDTO4Delete sysBookDTO4Delete, BindingResult bindingResult) {
        this.sysBookService.deleteBook(sysBookDTO4Delete.getBookIds());
        return Result.success();
    }

    /************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}