package com.sean.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.Parameter;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Value("${swagger2.is-enable}")
	private boolean isEnable;
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("SpringBoot后台权限管理系统")
				.description("集成MyBatis+Shiro后端接口文档")
				.version("0.1")
				.build();
	}
	
	@Bean
	public Docket createRestApi() {
		List<Parameter> pars = new ArrayList<>();
		
		ParameterBuilder tokenPar = new ParameterBuilder();
		tokenPar.name("authorization")
				.description("swagger测试用（模拟authorization传入） 非必填header")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false);
		
		ParameterBuilder refreshTokenPar = new ParameterBuilder();
		refreshTokenPar.name("refresh_token")
				.description("swagger测试用（模拟刷新token传入） 非必填header")
				.modelRef(new ModelRef("string"))
				.parameterType("header")
				.required(false);
		
		// 多个时候，直接添加pars即可
		pars.add(tokenPar.build());
		pars.add(refreshTokenPar.build());
		
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.sean.base.controller"))
				.paths(PathSelectors.any())
				.build()
				.globalOperationParameters(pars)
				.enable(isEnable);
	}
	
	
	
//	@Bean
//	public Docket createDocket() {
//		List<Parameter> parameterList = new ArrayList<>();
//		ParameterBuilder parameterBuilder = new ParameterBuilder();
//		parameterBuilder.name("token")
//						.description("传入用户认证凭证")
//						.modelRef(new ModelRef("String"))
//						.parameterType("header")
//						.required(false);
//		
//		parameterList.add(parameterBuilder.build());
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.apiInfo(apiInfo())
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.sean.base.controller"))
//				.paths(PathSelectors.any())
//				.build()
//				.globalOperationParameters(parameterList)
//				.enable(isEnable);
//	}
	

}
