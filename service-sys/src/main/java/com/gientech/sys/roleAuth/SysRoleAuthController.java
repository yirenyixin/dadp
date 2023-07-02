package com.gientech.sys.roleAuth;

import java.util.List;

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
import com.gientech.common.view.Tree;
import com.gientech.core.base.BaseController;
import com.gientech.core.log.annotation.OperLog;
import com.gientech.core.security.annotation.PreAuthorize;
import com.gientech.sys.role.SysRoleDTO4Get;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 操作权限--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-18】角色操作权限")
@ApiSort(value = 118) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/roleAuth")
public class SysRoleAuthController extends BaseController {

	@Autowired
	private SysRoleAuthService sysRoleAuthService;

	/**
	 * 【1】查询出树型权限list
	 * 
	 * @param sysRoleDTO4Get
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询出树型权限list")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "操作权限", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<List<Tree>> list(@Valid @RequestBody SysRoleDTO4Get sysRoleDTO4Get, BindingResult bindingResult) {
		return Result.success(this.sysRoleAuthService.listRoleAuth(sysRoleDTO4Get.getRoleId()));
	}

	/**
	 * 【2】保存角色的权限
	 * 
	 * @param sysRoleAuthDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "保存角色的权限")
	@ApiOperationSupport(order = 2)
	@PostMapping("/save")
	@OperLog(title = "操作权限", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysRole") // 菜单id或功能id
	public Result<Object> save(@Valid @RequestBody SysRoleAuthDTO4Save sysRoleAuthDTO4Save, BindingResult bindingResult) {
		this.sysRoleAuthService.saveRoleAuth(sysRoleAuthDTO4Save);
		return Result.success();
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
