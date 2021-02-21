package com.security.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.InMemoryAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * @author gaolingfeng
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenStore tokenStore;
    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    @Qualifier("clientDetailsServiceXX")
    private ClientDetailsService clientDetailsService;
    @Autowired
    private JwtAccessTokenConverter jwtAccessTokenConverter;

    /**
     * 使用数据库方式存储客户端信息,向数据库中查询信息
     * 自带的sql语句如下
     * SELECT client_id,client_secret,resource_ids,scope,authorized_grant_types,
     * web_server_redirect_uri,authorities,access_token_validity,refresh_token_validity,
     * additional_information,autoApprove
     * FROM oauth_client_details WHERE client_id = 'c1'
     *
     * @param dataSource 自带的sql不需要手写
     * @return
     * @author: gaolingfeng
     * @date: 2020/12/27 22:11
     */
    @Bean
    public ClientDetailsService clientDetailsServiceXX(DataSource dataSource) {
        ClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        ((JdbcClientDetailsService) clientDetailsService).setPasswordEncoder(passwordEncoder);
        return clientDetailsService;
    }

    /**
     * 将客户端信息存储到数据库
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetailsService);
    }

    /**
     * 配置客户端详情信息服务
     * @param clients
     * @throws Exception

     @Override public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
     clients.inMemory()//使用inMemory存储
     .withClient("c1")
     .secret(new BCryptPasswordEncoder().encode("secret"))
     //客户端可以访问的资源列表
     .resourceIds("res1")
     .authorizedGrantTypes("authorization_code","password","client_credentials","implicit","refresh_token")
     //允许的授权范围
     .scopes("all")
     .autoApprove(false)
     //加上验证回调地址
     .redirectUris("http://www.baidu.com");
     }*/

    /**
     * 配置令牌访问服务
     */
    @Bean
    public AuthorizationServerTokenServices tokenService() {
        //DefaultTokenServices 这个实例就是默认生成access_token的工具
        DefaultTokenServices service = new DefaultTokenServices();
        //客户端信息服务
        service.setClientDetailsService(clientDetailsService);
        //支持刷新令牌
        service.setSupportRefreshToken(true);
        //令牌存储策略
        service.setTokenStore(tokenStore);
        //设置令牌增强(JWT)
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(jwtAccessTokenConverter));
        service.setTokenEnhancer(tokenEnhancerChain);

        //令牌默认有效时间2小时 设置为一小时
        service.setAccessTokenValiditySeconds(3600);
        //刷新令牌默认有效期3天 设置为1天
        service.setRefreshTokenValiditySeconds(3600 * 24 * 1);
        return service;
    }

    /**
     * 设置授权码如何存取,暂时采用内存方式
     *
     * @param
     * @return
     * @author: gaolingfeng
     * @date: 2020/12/24 19:27
     */
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new InMemoryAuthorizationCodeServices();
    }

    /**
     * 令牌访问端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfigurer) {
        endpointsConfigurer
                //认证管理器
                .authenticationManager(authenticationManager)
                //授权码服务
                .authorizationCodeServices(authorizationCodeServices)
                //令牌管理服务
                .tokenServices(tokenService())
                //允许post方式访问令牌
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);
    }

    /**
     * 令牌访问端点安全策略
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
                //oauth/token_key公开
                .tokenKeyAccess("permitAll")
                //oauth/check_token公开
                .checkTokenAccess("permitAll()")
                //允许表单认证，申请令牌
                .allowFormAuthenticationForClients();
    }

}
