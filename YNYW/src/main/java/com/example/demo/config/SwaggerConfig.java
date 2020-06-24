package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {
	@Bean
    public Docket createRestApi() {
        //Docket是Swagger重要的构造器，为swagger配置提供默认值和方法
        //DocumentationType.SWAGGER_2表示使用swagger版本2.0
        return new Docket(DocumentationType.SWAGGER_2)
                //传入自定义的API描述信息
                .apiInfo(apiInfo())
                //返回一个api选择构建器
                .select()
                //指定扫描的包
                .apis(RequestHandlerSelectors.basePackage("com.example.demo"))
                .paths(PathSelectors.any())
                .build();
    }
 
    /**
     * 生成一个包含自定义信息的ApiInfo类
     * @return ApiInfo类
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("图书管理系统")
                .description("图书管理系统")
                //指定访问的路径
                .termsOfServiceUrl("http://localhost:8080/")
                //添加联系人信息
                .contact(new Contact("百度","http://www.baidu.com","mail.baidu.com"))
                //版本描述
                .version("1.0")
                .build();
    }
}