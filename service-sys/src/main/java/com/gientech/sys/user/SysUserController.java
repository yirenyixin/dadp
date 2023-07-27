package com.gientech.sys.user;

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
 * SysUser 控制器
 */
@Api(tags = "【1-20】用户表")
@ApiSort(value = 120)
@Validated
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends BaseController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 查询和分页
	 *
	 * @param sysUserDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "SYS_USER", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysUser")
	@PostMapping(value = "/list")
	public Result<DataGrid<SysUserVO>> list(@Valid @RequestBody SysUserDTO4List sysUserDTO4List, BindingResult bindingResult) {
		return Result.success(sysUserService.listSysUser(sysUserDTO4List));
	}

	/**
	 * 新增 SYS_USER
	 *
	 * @param sysUserDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增 SYS_USER")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "SYS_USER", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysUser")
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysUserDTO4Save sysUserDTO4Save, BindingResult bindingResult) {
		sysUserService.saveSysUser(sysUserDTO4Save);
		return Result.success();
	}

	/**
	 * 修改 SYS_USER
	 *
	 * @param sysUserDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改 SYS_USER")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "SYS_USER", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysUser")
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysUserDTO4Update sysUserDTO4Update, BindingResult bindingResult) {
		sysUserService.updateSysUser(sysUserDTO4Update);
		return Result.success();
	}

	/**
	 * 删除 SYS_USER
	 *
	 * @param sysUserDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除 SYS_USER")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "SYS_USER", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysUser")
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysUserDTO4Delete sysUserDTO4Delete, BindingResult bindingResult) {
		sysUserService.deleteSysUser(sysUserDTO4Delete.getUserIds());
		return Result.success();
	}



	@ApiOperation(value = "得到 userCodeInfo")
	@ApiOperationSupport(order = 5)
	@OperLog(title = "SYS_USER", operType = OperType.SEARCH)
//	@PreAuthorize(hasAuth = "sysUser")
	@PostMapping("/listCode")
	public String listCode(@Valid @RequestBody SysUserDTO4List sysUserDTO4List, BindingResult bindingResult) {
		return sysUserService.listSysUserCodeInfo(sysUserDTO4List);
//		return Result.success();
	}










	// TODO: 添加新的方法

}