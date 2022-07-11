package com.openaudio.oa.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.Collections;

/**
 * swagger2配置方案
 */
@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {

    @Bean
    public Docket createRestRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                //.protocols(Collections.singleton("https"))//不配置默认为http
                //.host("")//自定义配置host   https://doc.xiaominfo.com/knife4j/documentation/host.html
                .apiInfo(apiInfo())
                .select()
                //这里指定Controller扫描包路径
                //配置扫描，所有想要在swagger界面统一管理的接口，都必须在此包下
                .apis(RequestHandlerSelectors.basePackage("com.openaudio.oa.controller"))
                .paths(PathSelectors.any())
                .build()
                ;
    }

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("OpenAudio后台接口文档")//文档标题
                .description("后台接口文档")//文档描述
                .contact(new Contact("candyknight","http://www.candyknight.top/","1803042982@qq.com"))//联系人信息
                .termsOfServiceUrl("127.0.0.1")//设置服务url
                .version("1.0")//版本
                .build();
    }
}
