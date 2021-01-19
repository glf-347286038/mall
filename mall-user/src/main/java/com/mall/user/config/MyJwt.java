package com.mall.user.config;

import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JWT默认的返回数据只有6项
 * {
 *     "access_token": "b9c9e345-90c9-49f5-80ab-6ce5ed5a07c9",
 *     "token_type": "bearer",
 *     "refresh_token": "9f843e0e-1778-495d-859a-52a1a806c150",
 *     "expires_in": 7199,
 *     "scope": "seller-auth"
 *     "jti":"90a22aef-a473-4dd5-8418-65c6eec0c1c8"
 * }
 * 想要返回更多的数据要么将数据存入redis,要么放JWT中然后客户端解析
 * 作为第三方应用，此处将自定义信息放入token中更合适，类似于微信认证，token中会带有头像等信息
 * @author: gaolingfeng
 * @date: 2021/1/10 19:32
 * @description:
 */
@Data
public class MyJwt {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String jti;
    /**
     * 自定义的token信息，与授权方约定好
     */
    private AddInformation info;

    /**
     * 静态内部类，减少外部引用
     */
    @Data
    public static class AddInformation {
        /**
         * 登录名
         */
        private String userName;
        private String age;
        private String phone;
        private String sex;
    }
}
