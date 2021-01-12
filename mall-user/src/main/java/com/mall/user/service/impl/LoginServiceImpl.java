package com.mall.user.service.impl;

import com.mall.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author: gaolingfeng
 * @date: 2021/1/11 20:59
 * @description:
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
    @Override
    public void getJwt(String userName, String password) {
        
        System.out.println("GAOLINGFENG");
    }
}
