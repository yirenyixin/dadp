package com.gientech.core.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * Swagger的升级版，Knife4j配置
 * 
 * @author 胡砥峰
 *
 */
@Configuration
@EnableSwagger2WebMvc
@EnableKnife4j
public class SwaggerConfig {

	@Bean(value = "defaultApi2")
	public Docket defaultApi2() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2).apiInfo(new ApiInfoBuilder()

				.title("DADP开发平台API--token标识：Authorization   【前端注意】返回码999超时，要跳向登录页,998是没有权限")

				.description("DADP开发平台API")

				.termsOfServiceUrl("http://www.gientech.com/")

				.contact(new Contact("胡砥峰", "www.gientech.com", "14320235@qq.com")).version("1.0").build())

				// 分组名称
				.groupName("4.3版本").select()

				// 这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("com.gientech")).paths(PathSelectors.any()).build();

		return docket;
	}
}