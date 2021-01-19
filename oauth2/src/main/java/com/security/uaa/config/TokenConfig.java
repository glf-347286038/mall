package com.security.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * 在分布式系统当中，传统的登录会失效，各个微服务间用的不是同一台tomcat
 * 我们以前登录判断用户状态时通过tomcat session,现中有几台不同的tomcat,
 * 在这台登录会有tomcat session信息，但是跳到另外一个微服务，会没有登录状态，
 * 因此登录状态无法共享。
 * 1.什么时有状态？
 * 有状态服务，即服务端需要记录每次会话的客户端信息，从而识别客户端身份，根据身份进行请求
 * 的处理，典型的设计如tomcat的session。例如登录，用户登录后，我们把登录者
 * 的信息保存在服务端的session中，并且给用户一个cookie值，记录对应的session。
 * 然后下次请求，用户携带cookie值来，我们就能识别到对应的session,从而找到用户的信息。
 * 缺点：1.服务端若搭建集群，集群间的数据无法共享，于是用户状态无法共享，就不能实现一个跨服务的登录。
 *      2.服务端保存大量数据增加压力。
 *      3.服务端保存用户状态，无法进行水平拓展。
 *      4.客户端请求依赖服务端，多次请求必须访问同一台服务器。
 * 2.什么时无状态？
 * 识别用户的身份信息是由客户端自己去携带
 * 微服务集群中的每个服务，对外提供的都是Rest风格的接口。而Rest风格的一个最重要的
 * 规范就是服务的无状态性，即：
 *      1.服务端不保存客户端的任何信息
 *      2.客户端的每次请求必须具备自描述信息，通过这些信息识别客户端身份
 * 带来的好处：
 *  1.客户端请求不依赖服务端的信息，任何多次请求不需要访问同一台服务器
 *  2.服务端的集群和状态对客户端透明
 *  3.服务端可以任意的迁移和伸缩
 *  4.减小服务端的存储压力
 *
 * * @author gaolingfeng
 */
@Configuration
public class TokenConfig {
    /**
     * 对称密钥，没有非对称加密安全，公钥加密，私钥解密
     */
    private static final String SIGNING_KEY = "uaa123456789";

    @Bean
    public TokenStore tokenStore() {
        //JWT令牌存储方案
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        //JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        //使用自定的JWT实例
        JwtAccessTokenConverter converter = new MyJwt();
        //对称密钥，资源服务器使用该密钥来验证
        converter.setSigningKey(SIGNING_KEY);
        return converter;
    }

    /**
     * 令牌存储策略,使用内存存储令牌
     * @return
    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }
     */
}
