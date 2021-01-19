package com.mall.user.service.impl;

import com.mall.user.client.OauthServiceClient;
import com.mall.user.config.MyJwt;
import com.mall.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * @author: gaolingfeng
 * @date: 2021/1/11 20:59
 * @description:
 */
@Service
@Slf4j
@PropertySource("classpath:application.yml")
public class LoginServiceImpl implements LoginService {
    @Autowired
    private OauthServiceClient oauthServiceClient;

    @Value("${oauth2.client-id}")
    private String clientId;

    @Value("${oauth2.client-secret}")
    private String clientSecret;

    @Value("${oauth2.grant-type}")
    private String grantType;
    @Override
    public void getJwt(String userName, String password) {
        // 1.远程请求授权服务器获取token
        MyJwt myJwt = oauthServiceClient.getToken(userName,password,grantType,clientId,clientSecret);
    }
}
