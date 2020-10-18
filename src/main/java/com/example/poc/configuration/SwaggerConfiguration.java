package com.example.poc.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@ComponentScan(basePackages = { "com.example.poc" })
@Configuration
public class SwaggerConfiguration implements WebMvcConfigurer {

	@Value("${swagger.display.title}")
	private String title;

	@Value("${swagger.display.description}")
	private String description;

	@Value("${swagger.display.contact-name}")
	private String contactName;

	@Value("${swagger.display.contact-email}")
	private String contactEmail;

	@Value("${swagger.display.contact-url}")
	private String contactUrl;

	@Value("${swagger.display.terms-of-service-url}")
	private String termsOfService;

	@Value("${swagger.display.license}")
	private String license;

	@Value("${swagger.display.license-url}")
	private String licenseUrl;

	@Value("${swagger.display.version}")
	private String version;

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)).paths(PathSelectors.any())
				.build().apiInfo(apiEndPointsInfo());
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title(title).description(description)
				.contact(new Contact(contactName, contactUrl, contactEmail)).license(license)
				.termsOfServiceUrl(termsOfService).licenseUrl(licenseUrl).version(version).build();
	}

}
