package com.reg.config;


import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class SwaggerConfiguration {

    @Bean
    public Docket createProductRestApi() {
        List<ResponseMessage> responseMessageList = new ArrayList<>();
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
                .paths(PathSelectors.regex("/.*"))
                .build().globalResponseMessage(RequestMethod.POST, responseMessageList);
    }


    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("酒店标准接口 RESTful SERVER APIs")
                .description("酒店标准接口 RESTful SERVER APIs")
                .termsOfServiceUrl("http://hotel-api.xx.com")
                .contact(new Contact("wangzhiwei5010", "", "wangzhiwei5010@126.com"))
                .version("1.0.0")
                .build();
    }
}
