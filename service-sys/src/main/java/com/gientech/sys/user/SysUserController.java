package com.gientech.sys.user;

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
 * 用户--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-20】用户")
@ApiSort(value = 120) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysUserDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "用户", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysUser") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysUserVO>> list(@Valid @RequestBody SysUserDTO4List sysUserDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysUserService.listUser(sysUserDTO4List));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysUserDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "用户", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysUser") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysUserDTO4Save sysUserDTO4Save, BindingResult bindingResult) {
		this.sysUserService.saveUser(sysUserDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysUserDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "用户", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysUser") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysUserDTO4Update sysUserDTO4Update, BindingResult bindingResult) {
		this.sysUserService.updateUser(sysUserDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除--删除DTO
	 * 
	 * @param sysUserDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "用户", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysUser") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysUserDTO4Delete sysUserDTO4Delete, BindingResult bindingResult) {
		this.sysUserService.deleteUser(sysUserDTO4Delete.getUserIds());
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
