package com.belong.smart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("必龙同学的接口文档")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.belong.smart.controller"))
                .build();
                //.globalOperationParameters(jwtToken());  // 配置全局token注解
    }

    //配置文档信息
    private ApiInfo apiInfo() {
        // 作者信息
        Contact contact = new Contact("belong", "", "33158742@qq.com");
        return new ApiInfo(
                "SmartCity", // 标题
                "移动应用开发api接口", // 描述
                "v1.0", // 版本
                "", // 组织链接
                contact, // 作者信息
                "", // 许可
                "", // 许可连接
                new ArrayList<>()// 扩展
        );
    }

    // 配置全局token注解（很鸡肋）
    private List<Parameter> jwtToken() {
        String jwt = "Bearer {jwt}";

        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        // 声明 key
        tokenPar.name("Authorization")
                // 文字说明
                .description("jwt令牌")
                // 类型为字符串
                .modelRef(new ModelRef("string"))
                // 参数形式为 header 参数
                .parameterType("header")
                // 默认值
                .defaultValue(jwt)
                // 是否必须
                .required(false);
        pars.add(tokenPar.build());
        return pars;
    }
}
