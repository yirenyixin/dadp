package com.gientech.sys.func;

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
 * 功能--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-15】功能")
@ApiSort(value = 115) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/func")
public class SysFuncController extends BaseController {

	@Autowired
	private SysFuncService sysFuncService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysFuncDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "功能", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysFunc") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysFuncVO>> list(@Valid @RequestBody SysFuncDTO4List sysFuncDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysFuncService.listFunc(sysFuncDTO4List));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysFuncDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "功能", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysFunc") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysFuncDTO4Save sysFuncDTO4Save, BindingResult bindingResult) {
		this.sysFuncService.saveFunc(sysFuncDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysFuncDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "功能", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysFunc") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysFuncDTO4Update sysFuncDTO4Update, BindingResult bindingResult) {
		this.sysFuncService.updateFunc(sysFuncDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除--删除DTO
	 * 
	 * @param sysFuncDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "功能", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysFunc") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysFuncDTO4Delete sysFuncDTO4Delete, BindingResult bindingResult) {
		this.sysFuncService.deleteFunc(sysFuncDTO4Delete.getFuncIds());
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
