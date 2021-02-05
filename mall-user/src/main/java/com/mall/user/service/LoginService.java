package com.mall.user.service;

import com.mall.user.common.config.MyJwt;

/**
 * description:
 * @author: gaolingfeng
 * @date: 2021/1/11 20:59
 */
public interface LoginService {
    /**
     * 远程获得token
     *
     * @param userName 用户名
     * @param password 密码
     * @return MyJwt
     * @author: gaolingfeng
     * @date: 2021/1/11 21:03
     */
    MyJwt getJwt(String userName, String password);

    /**
     * 验证token
     *
     * @param token 用于验证的token
     * @return boolean
     */
    void checkToken(String token);

    /**
     * 刷新token
     *
     * @param refreshToken 用于刷新的token的refreshToken
     * @return MyJwt
     */
    MyJwt refreshToken(String refreshToken);

    /**
     * 退出登录
     *
     * @return String
     * @author: gaolingfeng
     * @date: 2021/2/5 9:35
     */
    String logout();
}
