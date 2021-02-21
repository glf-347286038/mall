package com.mall.product.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * @author gaolingfeng
 */
@Configuration
public class TokenConfig {
    /**
     * 对称密钥，必须和授权服务保持一致
     */
    private static final String SIGNING_KEY = "uaa123456789";

    @Bean
    public TokenStore tokenStore() {
        //JWT令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //对称密钥，资源服务器使用该密钥来验证
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }

    /**
     * 令牌存储策略,使用内存存储令牌
     * @return
     @Bean public TokenStore tokenStore(){
     return new InMemoryTokenStore();
     }
     */
}
