package com.mall.user.client;

import com.mall.user.common.config.MyJwt;
import org.springframework.cloud.openfeign.FeignClient;
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
     * @param grantType 授权方式
     * @param clientId 客户端id 一个应用对应一个
     * @param clientSecret 客户端密钥
     * @param password 用户登录时输入的密码
     * @param username 用户登录时输入的用户名
     * @return jwt
     */
    @PostMapping("/oauth/token")
    MyJwt getToken(@RequestParam("username")String username,
                   @RequestParam("password")String password,
                   @RequestParam("grant_type")String grantType,
                   @RequestParam("client_id")String clientId,
                   @RequestParam("client_secret")String clientSecret);

    /**
     * 验证token的有效性
     * @author: gaolingfeng
     * @date: 2021/2/4 1:13
     * @param token 认证token
     * @return void 无返回值
     */
    @PostMapping("/oauth/check_token")
    void checkAccessToken(@RequestParam("token")String token);

    /**
     * token失效 使用refresh_token重新请求token
     * @param refreshToken 刷新的token
     * @param grantType 授权方式
     * @param clientId 客户端id 一个应用对应一个
     * @param clientSecret 客户端密钥
     * @return jwt
     */
    @PostMapping("/oauth/token")
    MyJwt refreshToken(@RequestParam("refresh_token")String refreshToken,
                       @RequestParam("grant_type")String grantType,
                       @RequestParam("client_id")String clientId,
                       @RequestParam("client_secret")String clientSecret);
}
