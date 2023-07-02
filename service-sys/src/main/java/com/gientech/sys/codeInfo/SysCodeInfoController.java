package com.gientech.sys.codeInfo;

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
 * 代码信息--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-13】代码信息")
@ApiSort(value = 113) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/codeInfo")
public class SysCodeInfoController extends BaseController {

	@Autowired
	private SysCodeInfoService sysCodeInfoService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysCodeInfoDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "代码信息", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysCodeInfo") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysCodeInfoVO>> list(@Valid @RequestBody SysCodeInfoDTO4List sysCodeInfoDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysCodeInfoService.listCodeInfo(sysCodeInfoDTO4List));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysCodeInfoDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "代码信息", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysCodeInfo") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysCodeInfoDTO4Save sysCodeInfoDTO4Save, BindingResult bindingResult) {
		this.sysCodeInfoService.saveCodeInfo(sysCodeInfoDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysCodeInfoDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "代码信息", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysCodeInfo") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysCodeInfoDTO4Update sysCodeInfoDTO4Update, BindingResult bindingResult) {
		this.sysCodeInfoService.updateCodeInfo(sysCodeInfoDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除--删除DTO
	 * 
	 * @param sysCodeInfoDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "代码信息", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysCodeInfo-del") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysCodeInfoDTO4Delete sysCodeInfoDTO4Delete, BindingResult bindingResult) {
		this.sysCodeInfoService.deleteCodeInfo(sysCodeInfoDTO4Delete.getCodeInfoIds());
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
