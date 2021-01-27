package com.mall.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2021/1/26 22:24
 * @description:
 */
@Api(tags = "test")
@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {
    @ApiOperation(value = "测试")
    @GetMapping(value = "/test",produces = "application/json;charset=UTF-8")
    public String test() {
        return "nn";
    }

    @ApiOperation(value = "测试访问权限")
    @GetMapping(value = "/p3",produces = "application/json;charset=UTF-8")
    @PreAuthorize("hasAuthority('P2')")
    public String r1(){
        return "访问order资源";
    }
}