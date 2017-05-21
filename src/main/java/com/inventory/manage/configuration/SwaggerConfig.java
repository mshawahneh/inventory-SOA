package com.inventory.manage.configuration;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket postsApi() {
		 Docket docket=new Docket(DocumentationType.SWAGGER_2);
		
		 docket.groupName("public-api")
				.apiInfo(apiInfo()).select().paths(postPaths()).build();
		 
		 
		 docket.globalResponseMessage(RequestMethod.GET, ImmutableList.of(new ResponseMessageBuilder()
         .code(400)
         .message("Bad global Request")
         .responseModel(new ModelRef("Error")).build(),new ResponseMessageBuilder()
         .code(500)
         .message("Internal Server Global Error")
         .responseModel(new ModelRef("Error")).build()));
		 
		 return docket;
	}

	private Predicate<String> postPaths() {
		return regex("/.*");
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Service oriented architecture Project - Inventory System <p>by"
				+ "Rami Khalayleh<br>Mohammad Shwahneh<br>Noura")
				.description("Inventory system to simulate web services, composition, orchestration and other concepts")
				.termsOfServiceUrl("http://birzeit.edu")
				.license("BZU")
				.version("1.0").build();
	}
}
