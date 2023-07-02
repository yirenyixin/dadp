package com.gientech.sys.role;

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
 * 角色--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-17】角色")
@ApiSort(value = 117) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends BaseController {

	@Autowired
	private SysRoleService sysRoleService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysRoleDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "角色", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysRoleVO>> list(@Valid @RequestBody SysRoleDTO4List sysRoleDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysRoleService.listRole(sysRoleDTO4List));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysRoleDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "角色", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysRoleDTO4Save sysRoleDTO4Save, BindingResult bindingResult) {
		this.sysRoleService.saveRole(sysRoleDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysRoleDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "角色", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysRoleDTO4Update sysRoleDTO4Update, BindingResult bindingResult) {
		this.sysRoleService.updateRole(sysRoleDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除--删除DTO
	 * 
	 * @param sysRoleDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "角色", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysRoleDTO4Delete sysRoleDTO4Delete, BindingResult bindingResult) {
		this.sysRoleService.deleteRole(sysRoleDTO4Delete.getRoleIds());
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
