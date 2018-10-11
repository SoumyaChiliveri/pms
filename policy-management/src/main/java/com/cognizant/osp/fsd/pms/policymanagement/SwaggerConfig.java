package com.cognizant.osp.fsd.pms.policymanagement;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.cognizant.osp.fsd.pms.policymanagement.controller"))
                .paths(regex("/policy-management.*"))
                .build();
	}

	

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Policy Management API")
				.description("Policy Management API")
				.termsOfServiceUrl("http://cognizant.com")
				.contact("yogi@cognizant.com").license("OSP License")
				.licenseUrl("yogiosp@cognizant.com").version("1.0").build();
	}

}
