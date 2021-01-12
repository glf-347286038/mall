package com.mall.user.service;

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
     * @param
     * @return
     */
    void getJwt(String userName, String password);
}
