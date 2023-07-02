package com.gientech.sys.log;

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
 * 登录日志--Controller
 * 
 * @author 胡砥峰
 */
@Api(tags = "【1-21】登录日志")
@ApiSort(value = 121) // 排序号生成后要修改
@Validated
@RestController
@RequestMapping("/sys/log")
public class SysLogController extends BaseController {

	@Autowired
	private SysLogService sysLogService;

	/**
	 * 【1】查询和分页
	 * 
	 * @param sysLogDTO4List 查询DTO
	 * @param bindingResult
	 * @return
	 */
	@ApiOperation(value = "查询和分页")
	@ApiOperationSupport(order = 1)
	@OperLog(title = "登录日志", operType = OperType.SEARCH)
	@PreAuthorize(hasAuth = "sysLog") // 菜单id或功能id
	@PostMapping(value = "/list")
	public Result<DataGrid<SysLogVO>> list(@Valid @RequestBody SysLogDTO4List sysLogDTO4List, BindingResult bindingResult) {

		return Result.success(this.sysLogService.listLog(sysLogDTO4List));
	}

	/************* 【上面代码是基本的CRUD功能，新增的方法放在下面！】 *********************************************************************************************/

}
