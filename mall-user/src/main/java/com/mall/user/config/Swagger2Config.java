package com.mall.user.config;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiKeyAuthDefinition;
import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/1/17 22:27
 * @description:
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket createRestApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .apiInfo(apiInfo())
                .select()
                // 加了ApiOperation注解的类，才生成接口文档
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                // 这个包下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("com.mall.user.controller"))
                .paths(PathSelectors.any())
                .build()
                //不会加bearer
                //.securitySchemes(security())
                .globalOperationParameters(jwtToken())
                // 生产环境可以关闭
                .enable(true);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("用户微服务接口Api")
                .description("用户微服务api接口文档")
                .version("1.0")
                .build();
    }

    /**
     * 这种方式深没有bearer
     * @return
     */
    private List<ApiKey> security() {
        //Authorization
        List<ApiKey> apiKeyList= new ArrayList<ApiKey>();
        apiKeyList.add(new ApiKey("Authorization", "Authorization", "header"));
        return apiKeyList;
    }

    /**
     * 采用jwt token类型为bearer方式 每次访问接口都要加token
     * @return 配置bearer token
     */
    private List<Parameter> jwtToken(){
        String jwt = "Bearer {jwt}";
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        // 声明 key
        tokenPar.name("Authorization")
                .description("jwt令牌")
                .modelRef(new ModelRef("String"))
                .parameterType("header")
                .defaultValue(jwt)
                .required(false);
        pars.add(tokenPar.build());
        return pars;
    }
}

