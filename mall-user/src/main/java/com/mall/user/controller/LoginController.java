package com.mall.user.controller;

import com.mall.user.client.OauthServiceClient;
import com.mall.user.config.MyJwt;
import com.mall.user.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:01
 * @description:
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private OauthServiceClient oauthServiceClient;

    @GetMapping(value = "/p")
//    标记拥有p1权限方可访问此url
//    @PreAuthorize("hasAnyAuthority()")
    @PreAuthorize("hasAuthority('P2')")
    public String r1(){
        return "访问order资源";
    }

    @GetMapping(value = "/login")
    public String Login(String userName,String password){
        MyJwt my = oauthServiceClient.getToken("password","我习惯做唯一","glf491550",
                "c1","secret");
        System.out.println(my);
        return my.toString();
    }

    @GetMapping(value = "/test")
    public String test(){
        MyJwt my = oauthServiceClient.getToken("password","我习惯做唯一","glf491550",
                "c1","secret");
        System.out.println(my);
        return "nn";
    }
}
