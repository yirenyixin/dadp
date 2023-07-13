package com.gientech.pcm.orgRel;

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
 * 机构归属关系--Controller
 *
 * @author 吴俊达
 */
@Api(tags = "【2-02】机构归属关系")
@ApiSort(value = 202) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/pcm/orgRel")
public class PcmOrgRelController extends BaseController {
    @Autowired
    private PcmOrgRelService pcmOrgRelService;

    /**
     * 【1】新增后保存
     *
     * @param pcmOrgRelDTO4Save 新增DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "新增后保存")
    @ApiOperationSupport(order = 1)
    @OperLog(title = "机构归属关系", operType = OperType.INSERT)
//    @PreAuthorize(hasAuth = "pcmOrgRel") // 菜单id或功能id
    @PostMapping("/save")
    public Result<Object> save(@Valid @RequestBody PcmOrgRelDTO4Save pcmOrgRelDTO4Save, BindingResult bindingResult) {
        this.pcmOrgRelService.saveOrgRel(pcmOrgRelDTO4Save);
        return Result.success();
    }

    /**
     * 【2】删除
     *
     * @param pcmOrgRelDTO4Delete
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "删除")
    @ApiOperationSupport(order = 2)
    @OperLog(title = "机构归属关系", operType = OperType.DELETE)
//    @PreAuthorize(hasAuth = "pcmOrgRel") // 菜单id或功能id
    @PostMapping("/delete")
    public Result<Object> delete(@Valid @RequestBody PcmOrgRelDTO4Delete pcmOrgRelDTO4Delete, BindingResult bindingResult) {
        this.pcmOrgRelService.deleteOrgRel(pcmOrgRelDTO4Delete.getOrgRelIds());
        return Result.success();
    }

    /**
     * 【3】修改
     *
     * @param pcmOrgRelDTO4Update 修改DTO，一定要传主键
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "修改")
    @ApiOperationSupport(order = 3)
    @OperLog(title = "机构归属关系", operType = OperType.UPDATE)
//    @PreAuthorize(hasAuth = "pcmOrgRel") // 菜单id或功能id
    @PostMapping("/update")
    public Result<Object> update(@Valid @RequestBody PcmOrgRelDTO4Update pcmOrgRelDTO4Update, BindingResult bindingResult) {
        this.pcmOrgRelService.updateOrgRel(pcmOrgRelDTO4Update);
        return Result.success();
    }

    /**
     * 【4】查询和分页
     *
     * @param pcmOrgRelDTO4List 查询DTO
     * @param bindingResult
     * @return
     */
    @ApiOperation(value = "查询和分页")
    @ApiOperationSupport(order = 4)
    @OperLog(title = "机构归属关系", operType = OperType.SEARCH)
//    @PreAuthorize(hasAuth = "pcmOrgRel") // 菜单id或功能id
    @PostMapping(value = "/list")
    public Result<DataGrid<PcmOrgRelVO>> list(@Valid @RequestBody PcmOrgRelDTO4List pcmOrgRelDTO4List, BindingResult bindingResult) {
        return Result.success(this.pcmOrgRelService.listOrgRel(pcmOrgRelDTO4List));
    }
}
