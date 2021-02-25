package com.mall.user.service.impl;

import com.mall.user.UserServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

class LoginServiceImplTest {
    @Test
    void getJwt() {
        // 测试MD5加密
        String password = "333";
        String passwordInput = "333";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String md5 = bCryptPasswordEncoder.encode(password);
        System.out.println(bCryptPasswordEncoder.matches(passwordInput,md5));
    }
}