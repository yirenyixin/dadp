package com.gientech.pcm.userRel;

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
 * 客户经理归属关系--Controller
 *
 * @author 吴俊达
 */
@Api(tags = "【2-06】客户经理归属关系")
@ApiSort(value = 203) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/pcm/userRel")
public class PcmUserRelController extends BaseController {
    @Autowired
    private PcmUserRelService pcmUserRelService;

    /**
     * 【1】新增后保存
     *
     * @param pcmUserRelDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "机构归属关系", operType = OperType.INSERT)
    @PreAuthorize(hasAuth = "pcmUserRel") // 菜单id或功能id
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmUserRelDTO4Save pcmUserRelDTO4Save, BindingResult bindingResult) {
        this.pcmUserRelService.saveUserRel(pcmUserRelDTO4Save);
        return Result.success();
    }

    /**
     * 【2】删除
     *
     * @param pcmUserRelDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "机构归属关系", operType = OperType.DELETE)
    @PreAuthorize(hasAuth = "pcmUserRel") // 菜单id或功能id
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmUserRelDTO4Delete pcmUserRelDTO4Delete, BindingResult bindingResult) {
        this.pcmUserRelService.deleteUserRel(pcmUserRelDTO4Delete.getUserRelIds());
        return Result.success();
    }

    /**
     * 【3】修改
     *
     * @param pcmUserRelDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "机构归属关系", operType = OperType.UPDATE)
    @PreAuthorize(hasAuth = "pcmUserRel") // 菜单id或功能id
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmUserRelDTO4Update pcmUserRelDTO4Update, BindingResult bindingResult) {
        this.pcmUserRelService.updateUserRel(pcmUserRelDTO4Update);
        return Result.success();
    }

    /**
     * 【4】查询和分页
     *
     * @param pcmUserRelDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "机构归属关系", operType = OperType.SEARCH)
    @PreAuthorize(hasAuth = "pcmUserRel") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmUserRelVO>> list(@Valid @RequestBody PcmUserRelDTO4List pcmUserRelDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmUserRelService.listUserRel(pcmUserRelDTO4List));
    }
}
