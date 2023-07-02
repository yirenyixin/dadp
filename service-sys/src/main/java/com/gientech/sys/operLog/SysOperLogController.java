package com.gientech.sys.operLog;

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
import springfox.documentation.annotations.ApiIgnore;

/**
 * 操作日志--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-22】操作日志")
@ApiSort(value = 122) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/operLog")
public class SysOperLogController extends BaseController {

	@Autowired
	private SysOperLogService sysOperLogService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysOperLogDTO4List
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "操作日志", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysOperLog") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysOperLogVO>> list(@Valid @RequestBody SysOperLogDTO4List sysOperLogDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysOperLogService.listOperLog(sysOperLogDTO4List));
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

	/**
	 * 【2】保存操作日志，自动记录日志，不开放API
	 * 
	 * @param sysOperLog    新增DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiIgnore // 忽略，不显示API
	@PostMapping("/save")
	public Result<Object> save(@Valid @RequestBody SysOperLog sysOperLog) {
		this.sysOperLogService.saveOperLog(sysOperLog);
		return Result.success();
	}
}
