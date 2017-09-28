/**
 * 
 */
package com.qdynasty.rtmService;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author fei.qin
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.framework.portal.controller")).paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("后台管理系统").description("描述：后台管理系统").termsOfServiceUrl("http://127.0.0.1/")
				.contact(new Contact("fei", "http://127.0.0.1/", "fei.qin@quanshi.com")).version("1.0.1").build();
	}
}
