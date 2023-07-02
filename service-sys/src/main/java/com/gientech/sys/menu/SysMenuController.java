package com.gientech.sys.menu;

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
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 菜单--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-14】菜单")
@ApiSort(value = 114) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends BaseController {

	@Autowired
	private SysMenuService sysMenuService;

	/**
	 * 【1】查询出树型list（不传参，显示全部。传参显示此节点为最高节点）
	 * 
	 * @param sysMenuDTO4List
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询出树型list")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "菜单", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysMenu") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<List<Tree>> list(@Valid @RequestBody SysMenuDTO4List sysMenuDTO4List, BindingResult bindingResult) {
		return Result.success(this.sysMenuService.listMenu(sysMenuDTO4List.getTopMenuId()));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysMenuDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "菜单", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysMenu") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysMenuDTO4Save sysMenuDTO4Save, BindingResult bindingResult) {
		this.sysMenuService.saveMenu(sysMenuDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysMenuDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "菜单", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysMenu") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysMenuDTO4Update sysMenuDTO4Update, BindingResult bindingResult) {
		this.sysMenuService.updateMenu(sysMenuDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除
	 * 
	 * @param sysMenuDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "菜单", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysMenu") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysMenuDTO4Delete sysMenuDTO4Delete, BindingResult bindingResult) {
		this.sysMenuService.deleteMenu(sysMenuDTO4Delete.getMenuId());
		return Result.success();
	}

	/**
	 * 【5】根据id获取tree对象
	 * 
	 * @param sysMenuDTO4Get
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "根据id获取菜单对象")
	@ApiOperationSupport(order = 5)
	@OperLog(title = "菜单", operType = OperType.OTHER)
	@PreAuthorize(hasAuth = "sysMenu") // 菜单id或功能id
	@PostMapping("/get")
	public Result<Object> get(@Valid @RequestBody SysMenuDTO4Get sysMenuDTO4Get, BindingResult bindingResult) {

		SysMenu sysMenu = this.sysMenuService.getMenu(sysMenuDTO4Get.getMenuId());

		if (sysMenu != null) {
			return Result.success(sysMenu);
		} else {
			return Result.error("没找到数据,请检查!");
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

	/**
	 * 【11】前端菜单显示
	 *
	 * @return
	 */
	@ApiOperation(value = "前端菜单显示")
	@ApiOperationSupport(order = 6)
	@PostMapping("/listMenuByAuth")
	public Result<List<SysMenu>> listMenuByAuth() {
		return Result.success(this.sysMenuService.listMenuByAuth());
	}

}
