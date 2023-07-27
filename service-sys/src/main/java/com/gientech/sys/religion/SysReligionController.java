package com.gientech.sys.religion;

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
 * 宗教--Controller
 *
 * @author 吴俊达
 */
@Api(tags = "【1-66】宗教")
@ApiSort(value = 166) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/religion")
public class SysReligionController extends BaseController {
    @Autowired
    private SysReligionService sysReligionService;

    /**
     * 【1】新增后保存
     *
     * @param sysReligionDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "宗教", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "sysReligion") // 菜单id或功能id
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody SysReligionDTO4Save sysReligionDTO4Save, BindingResult bindingResult) {
        this.sysReligionService.saveOrg(sysReligionDTO4Save);
        return Result.success();
    }

    /**
     * 【2】修改
     *
     * @param sysReligionDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "宗教", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "sysReligion") // 菜单id或功能id
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody SysReligionDTO4Update sysReligionDTO4Update, BindingResult bindingResult) {
        this.sysReligionService.updateReligion(sysReligionDTO4Update);
        return Result.success();
    }

    /**
     * 【3】删除
     *
     * @param sysReligionDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "宗教", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "sysReligion") // 菜单id或功能id
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody SysReligionDTO4Delete sysReligionDTO4Delete, BindingResult bindingResult) {
        this.sysReligionService.deleteReligion(sysReligionDTO4Delete.getReligionIds());
        return Result.success();
    }

    /**
     * 【4】查询和分页
     *
     * @param sysReligionDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "宗教", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "sysReligion") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<SysReligionVO>> list(@Valid @RequestBody SysReligionDTO4List sysReligionDTO4List, BindingResult bindingResult) {

        return Result.success(this.sysReligionService.listReligion(sysReligionDTO4List));
    }

}
