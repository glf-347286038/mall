package com.mall.user.service;

import com.mall.user.config.MyJwt;

/**
 * description:
 * @author: gaolingfeng
 * @date: 2021/1/11 20:59
 */
public interface LoginService {
    /**
     * 远程获得token
     * @author: gaolingfeng
     * @date: 2021/1/11 21:03
     * @param userName
     * @param password
     * @return
     */
    MyJwt getJwt(String userName, String password);
}
