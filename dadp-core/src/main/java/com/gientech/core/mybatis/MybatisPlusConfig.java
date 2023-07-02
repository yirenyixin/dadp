package com.gientech.core.mybatis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;

/**
 * MybatisPlus 设置拦截器：分页和乐观锁。
 * 
 * @author 胡砥峰
 *
 */
@Configuration
public class MybatisPlusConfig {

	/**
	 * MybatisPlusInterceptor
	 * 
	 * @return
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {

		MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();

		// 这是分页拦截器,要指定数据库类型，因为ORACLE_12C，代码认不出来
		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor();
//		PaginationInnerInterceptor paginationInnerInterceptor = new PaginationInnerInterceptor(DbType.ORACLE_12C);// DbType：数据库类型(根据类型获取应使用的分页方言)

//		paginationInnerInterceptor.setOverflow(true);// 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求 默认false
		paginationInnerInterceptor.setMaxLimit(500L);// 设置最大单页限制数量，默认 500 条，-1 不受限制

		interceptor.addInnerInterceptor(paginationInnerInterceptor); // 分页插件；
		interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 乐观锁插件 @version需要这个配合

		return interceptor;
	}

}
