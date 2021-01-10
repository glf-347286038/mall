package com.mall.order.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:21
 * @description:
 */
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Autowired
    private TokenStore tokenStore;
    /**
     * 资源id，要到oauth2中的AuthorizationServer中的客户端详情信息服务中配置
     * 在授权服务器中的数据库中保存
     */
    public static final String RESOURCE_ID = "mall-order";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId(RESOURCE_ID)
                //验证令牌的服务，令牌过来访问，得验证，远程校验方式
                //.tokenServices(tokenService())
                //采用JWT方式
                .tokenStore(tokenStore)
                .stateless(true);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/**")
                //在oauth2中配置了范围，此范围若不存在oauth2的设置中，令牌就不管用
                .access("#oauth2.hasScope('ROLE_USER')")
                .and().csrf().disable()
                .sessionManagement()
                //基于token，session就不用再记录了
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * 资源服务令牌解析服务,这种方式每次资源服务都要去授权服务验证，对性能有影响
     * @author: gaolingfeng
     * @date: 2020/12/26 18:39
     * @param
     * @return
    @Bean
    public ResourceServerTokenServices tokenService(){
        //使用远程服务请求授权服务器校验token,必须指定校验token的url、client_id、client_secret
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://localhost:8001/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }
     */

}
