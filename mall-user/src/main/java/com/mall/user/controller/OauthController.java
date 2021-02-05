package com.mall.user.controller;

import com.mall.user.common.config.MyJwt;
import com.mall.user.service.LoginService;
import com.mall.user.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:01
 * @description:
 */
@Api(tags = "oauth")
@RestController
@RequestMapping(value = "oauth")
@Slf4j
public class OauthController {
    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "测试访问")
    @GetMapping(value = "/test")
    public String test() {
        return "访问成功8083";
    }

    @ApiOperation(value = "登录检查")
    @GetMapping(value = "/login")
    public ResponseData<MyJwt> login(@RequestParam("userName") String userName,
                                     @RequestParam("password") String password){
        log.info("<====LoginController login{},{}",userName,password);
        ResponseData<MyJwt> responseData = new ResponseData<>();
        try {
            responseData.setData(loginService.getJwt(userName, password));
        } catch (Exception e) {
            log.error("<====LoginController login{}", e.getMessage(), e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "验证token有效性")
    @GetMapping(value = "/checkToken")
    public ResponseData<Boolean> checkToken(@RequestParam("token") String token) {
        log.info("<====LoginController checkToken{}", token);
        ResponseData<Boolean> responseData = new ResponseData<>();
        try {
            loginService.checkToken(token);
        } catch (Exception e) {
            log.error("<====LoginController checkToken{}", e.getMessage(), e);
            responseData.setData(false);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "刷新token")
    @GetMapping(value = "/refreshToken")
    public ResponseData<MyJwt> refreshToken(@RequestParam("refreshToken") String refreshToken) {
        log.info("<====LoginController refreshToken{}", refreshToken);
        ResponseData<MyJwt> responseData = new ResponseData<>();
        try {
            responseData.setData(loginService.refreshToken(refreshToken));
        } catch (Exception e) {
            log.error("<====LoginController refreshToken{}", e.getMessage(), e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "退出登录")
    @GetMapping(value = "/logout")
    public ResponseData<String> logout(){
        ResponseData<String> responseData = new ResponseData<>();
        try{

        }catch (Exception e){
            log.error("<====LoginController logout{}",e.getMessage(), e);
        }
        return responseData;
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
