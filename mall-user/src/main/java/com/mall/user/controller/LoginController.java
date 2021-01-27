package com.mall.user.controller;

import com.mall.user.service.LoginService;
import com.mall.user.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:01
 * @description:
 */
@Api(tags = "login")
@RestController
@RequestMapping(value = "login")
@Slf4j
public class LoginController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "登录检查")
    @GetMapping(value = "/login")
    public ResponseData Login(String userName,String password){
        log.info("LoginController login",userName,password);
        ResponseData responseData = new ResponseData();
        try {
            responseData.setData(loginService.getJwt(userName, password));
        } catch (Exception e) {
            log.info("LoginController login", e.getMessage());
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken")
    public ResponseData refreshToken(String refreshToken) {
        log.info("LoginController refreshToken", refreshToken);
        ResponseData responseData = new ResponseData();
        try {
            responseData.setData(loginService.refreshToken(refreshToken));
        } catch (Exception e) {
            log.info("LoginController refreshToken", e.getMessage());
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "测试访问权限")
    @GetMapping(value = "/test")
    public String test() {
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
