package com.mall.user.service.impl;

import com.mall.user.client.OauthServiceClient;
import com.mall.user.common.config.MyJwt;
import com.mall.user.mapper.MallUserMapper;
import com.mall.user.model.entity.MallUser;
import com.mall.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

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

    @Autowired
    private MallUserMapper mallUserMapper;

    @Value("${oauth2.client-id}")
    private String clientId;

    @Value("${oauth2.client-secret}")
    private String clientSecret;

    @Value("${oauth2.grant-type}")
    private String grantType;

    public static final String GRANT_TYPE = "refresh_token";

    @Override
    public MyJwt getJwt(String userName, String password) {
        // 远程请求授权服务器获取token
        MyJwt myJwt = oauthServiceClient.getToken(userName, password, grantType, clientId, clientSecret);
        // 判断mall-user库中是否有该账号,没有则新建

        MallUser mallUser = mallUserMapper.selectById(myJwt.getInfo().getUserId());
        if(ObjectUtils.isEmpty(mallUser)){
            
        }
        return myJwt;
    }

    @Override
    public void checkToken(String token) {
        oauthServiceClient.checkAccessToken(token);
    }

    @Override
    public MyJwt refreshToken(String refreshToken) {
        // 远程刷新token
        return oauthServiceClient.refreshToken(refreshToken, GRANT_TYPE, clientId, clientSecret);
    }

    @Override
    public String logout() {
        return "退出登录";
    }
}
