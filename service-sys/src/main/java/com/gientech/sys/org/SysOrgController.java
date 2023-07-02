package com.gientech.sys.org;

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
 * 机构--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-16】机构")
@ApiSort(value = 116) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/org")
public class SysOrgController extends BaseController {

	@Autowired
	private SysOrgService sysOrgService;

	/**
	 * 【1】查询出树型list（不传参，显示全部。传参显示此节点为最高节点）
	 * 
	 * @param sysOrgDTO4List
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询出树型list")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "机构", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysOrg") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<List<Tree>> list(@Valid @RequestBody SysOrgDTO4List sysOrgDTO4List, BindingResult bindingResult) {
		return Result.success(this.sysOrgService.listOrg(sysOrgDTO4List.getTopOrgId()));
	}

	/**
	 * 【2】新增后保存
	 * 
	 * @param sysOrgDTO4Save 新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "新增后保存")
	@ApiOperationSupport(order = 2)
	@OperLog(title = "机构", operType = OperType.INSERT)
	@PreAuthorize(hasAuth = "sysOrg") // 菜单id或功能id
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysOrgDTO4Save sysOrgDTO4Save, BindingResult bindingResult) {
		this.sysOrgService.saveOrg(sysOrgDTO4Save);
		return Result.success();
	}

	/**
	 * 【3】修改
	 * 
	 * @param sysOrgDTO4Update 修改DTO，一定要传主键
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "修改")
	@ApiOperationSupport(order = 3)
	@OperLog(title = "机构", operType = OperType.UPDATE)
	@PreAuthorize(hasAuth = "sysOrg") // 菜单id或功能id
	@PostMapping("/update")
	public Result<Object> update(@Valid @RequestBody SysOrgDTO4Update sysOrgDTO4Update, BindingResult bindingResult) {
		this.sysOrgService.updateOrg(sysOrgDTO4Update);
		return Result.success();
	}

	/**
	 * 【4】删除
	 * 
	 * @param sysOrgDTO4Delete
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "删除")
	@ApiOperationSupport(order = 4)
	@OperLog(title = "机构", operType = OperType.DELETE)
	@PreAuthorize(hasAuth = "sysOrg") // 菜单id或功能id
	@PostMapping("/delete")
	public Result<Object> delete(@Valid @RequestBody SysOrgDTO4Delete sysOrgDTO4Delete, BindingResult bindingResult) {
		this.sysOrgService.deleteOrg(sysOrgDTO4Delete.getOrgId());
		return Result.success();
	}

	/**
	 * 【5】根据id获取tree对象
	 * 
	 * @param sysOrgDTO4Get
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "根据id获取机构对象")
	@ApiOperationSupport(order = 5)
	@OperLog(title = "机构", operType = OperType.OTHER)
	@PreAuthorize(hasAuth = "sysOrg") // 菜单id或功能id
	@PostMapping("/get")
	public Result<Object> get(@Valid @RequestBody SysOrgDTO4Get sysOrgDTO4Get, BindingResult bindingResult) {

		SysOrg sysOrg = this.sysOrgService.getOrg(sysOrgDTO4Get.getOrgId());

		if (sysOrg != null) {
			return Result.success(sysOrg);
		} else {
			return Result.error("没找到数据,请检查!");
		}
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
