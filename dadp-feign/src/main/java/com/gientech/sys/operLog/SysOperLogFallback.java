package com.gientech.sys.operLog;

import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Component;

import com.gientech.common.Result;

import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;

/**
 * 【重要提示：】代码自动生成之后，在java代码中，不用的方法都要删除！不用的代码也要删除！
 * 
 * @用途:操作日志Fallback,负载均衡接口的错误提示。。
 * 
 * @author 胡砥峰
 */
@Component
@Slf4j
public class SysOperLogFallback implements FallbackFactory<SysOperLogFeign> {

	@Override
	public SysOperLogFeign create(Throwable throwable) {
		log.info("fallback; reason was: {}", throwable.getMessage());
		return new SysOperLogFeign() {

			@Override
			public Result<T> save(SysOperLog sysOperLog) {
				return Result.error("服务繁忙，请稍后再试!");
			}

			/************* 【以上代码是本功能基本的CRUD功能,下面代码是其它业务功能!】 ********************************************/

		};
	}
}
