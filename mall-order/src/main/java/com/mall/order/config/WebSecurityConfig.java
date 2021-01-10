package com.mall.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * The bean 'metaDataSourceAdvisor' could not be registered. A bean with that name has already been defined and overriding is disabled.
 * @author gaolingfeng
 */
//@Configuration
//@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    /**
     * 安全拦截机制
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable()
                .authorizeRequests()
                //所有/r/**必须认证通过
                .antMatchers("/r/**").authenticated()
                //除了/r/**,其他的请求可以访问
                .anyRequest().permitAll();
    }

}
