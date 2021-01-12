package com.mall.user.client;

import com.mall.user.config.MyJwt;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.jwt.Jwt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求Oauth2客户端
 * @author: gaolingfeng
 * @date: 2021/1/12 23:32
 * @return
 */
@FeignClient("oauth2")
public interface OauthServiceClient {
    /**
     * description:
     * @author: gaolingfeng
     * @date: 2021/1/12 23:42
     * @param grant_type 授权方式
     * @param client_id 客户端id 一个应用对应一个
     * @param client_secret 客户端密钥
     * @param password 用户登录时输入的密码
     * @param username 用户登录时输入的用户名
     * @return jwt
     */
    @PostMapping("/oauth/token")
    MyJwt getToken(@RequestParam("grant_type")String grant_type,
                   @RequestParam("username")String username,
                   @RequestParam("password")String password,
                   @RequestParam("client_id")String client_id,
                   @RequestParam("client_secret")String client_secret);
}
