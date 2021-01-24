package com.security.uaa.config;

import com.security.uaa.mapper.OauthUserMapper;
import com.security.uaa.model.entity.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT默认的返回数据只有6项
 * {
 *     "access_token": "b9c9e345-90c9-49f5-80ab-6ce5ed5a07c9",
 *     "token_type": "bearer",
 *     "refresh_token": "9f843e0e-1778-495d-859a-52a1a806c150",
 *     "expires_in": 7199,
 *     "scope": "seller-auth"
 * }
 * 想要返回更多的数据要么将数据存入redis,要么放JWT中然后客户端解析
 * 作为第三方应用，此处将自定义信息放入token中更合适，类似于微信认证，token中会带有头像等信息
 * @author: gaolingfeng
 * @date: 2021/1/10 19:32
 * @description:
 */
public class MyJwt extends JwtAccessTokenConverter {
    @Autowired
    private OauthUserMapper oauthUserMapper;
    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken auth2AccessToken, OAuth2Authentication auth2Authentication){
        Map<String, Object> additionalInformation = new HashMap<>(16);
        Map<String, Object> info = new HashMap<>(16);
        User user = (User) auth2Authentication.getPrincipal();
        info.put("userName",user.getUsername());
        OauthUser oauthUser = oauthUserMapper.queryOauthUser(new OauthUser(){
            {
                setUserName(user.getUsername());
            }
        }).get(0);
        info.put("userId",oauthUser.getUserId());
        info.put("phone",oauthUser.getPhone());
        info.put("age",oauthUser.getAge());
        info.put("sex",oauthUser.getSex());
        additionalInformation.put("info" , info);
        ((DefaultOAuth2AccessToken) auth2AccessToken).setAdditionalInformation(additionalInformation);
        return super.enhance(auth2AccessToken,auth2Authentication);
    }
}
