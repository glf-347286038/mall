package com.mall.user.controller;

import com.mall.user.client.OauthServiceClient;
import com.mall.user.config.MyJwt;
import com.mall.user.service.LoginService;
import com.mall.user.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:01
 * @description:
 */
@Api(tags = "login")
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private OauthServiceClient oauthServiceClient;

    @ApiOperation(value = "登录检查")
    @GetMapping(value = "/login")
    public ResponseData Login(String userName,String password){
        log.info("LoginController login",userName,password);
        ResponseData responseData = new ResponseData();
        try{
            responseData.setData(loginService.getJwt(userName,password));
            responseData.setSuccess(true);
        }catch (Exception e){
            log.info("LoginController login",e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @GetMapping(value = "/test")
    public String test(){
        MyJwt my = oauthServiceClient.getToken("password","我习惯做唯一","glf491550",
                "c1","secret");
        System.out.println(my);
        return "nn";
    }

    @ApiOperation(value = "测试访问权限")
    @GetMapping(value = "/p3")
//    标记拥有p3权限方可访问此url
//    @PreAuthorize("hasAnyAuthority()")
    @PreAuthorize("hasAuthority('P2')")
    public String r1(){
        return "访问order资源";
    }
}
