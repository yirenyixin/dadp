package com.gientech.sys.roleData;

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
 * 数据权限--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-19】数据权限")
@ApiSort(value = 119) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/roleData")
public class SysRoleDataController extends BaseController {

	@Autowired
	private SysRoleDataService sysRoleDataService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysRoleDataDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "数据权限", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysRoleDataVO>> list(@Valid @RequestBody SysRoleDataDTO4List sysRoleDataDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysRoleDataService.listRoleData(sysRoleDataDTO4List));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysRoleDataDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "数据权限", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysRoleDataDTO4Save sysRoleDataDTO4Save, BindingResult bindingResult) {
		this.sysRoleDataService.saveRoleData(sysRoleDataDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysRoleDataDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "数据权限", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysRoleDataDTO4Update sysRoleDataDTO4Update, BindingResult bindingResult) {
		this.sysRoleDataService.updateRoleData(sysRoleDataDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除--删除DTO
	 * 
	 * @param sysRoleDataDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "数据权限", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysRoleDataDTO4Delete sysRoleDataDTO4Delete, BindingResult bindingResult) {
		this.sysRoleDataService.deleteRoleData(sysRoleDataDTO4Delete.getRoleDataIds());
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
