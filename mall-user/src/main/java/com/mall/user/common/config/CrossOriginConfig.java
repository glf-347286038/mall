package com.mall.user.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author: gaolingfeng
 * @date: 2021/1/24 17:41
 * @description: 配置跨域访问
 */
//@Configuration 会与网关依赖冲突
public class CrossOriginConfig implements WebMvcConfigurer {
    static final String[] ORIGINS = new String[]{"GET", "POST", "PUT", "DELETE"};

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedHeaders("*")
                .allowedMethods(ORIGINS)
                .allowCredentials(true)
                // 请求的有效期
                .maxAge(3600);
    }
}