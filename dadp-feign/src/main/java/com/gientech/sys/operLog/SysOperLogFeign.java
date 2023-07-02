package com.gientech.sys.operLog;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gientech.common.Result;

/**
 * 【重要提示：】代码自动生成之后，在java代码中，不用的方法都要删除！不用的代码也要删除！
 * 
 * @用途:操作日志Feign,负载均衡接口
 * 
 * @author 胡砥峰
 */
@Component
@FeignClient(value = "service-sys", contextId = "sysOperLogFeign", fallbackFactory = SysOperLogFallback.class)
public interface SysOperLogFeign {

	@PostMapping("/sys/operLog/save")
	public Result<T> save(@RequestBody SysOperLog sysOperLog);

	/************* 【以上代码是本功能基本的CRUD功能,下面代码是其它业务功能!】 ********************************************/

}
