package com.mall.order.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 18:01
 * @description:
 */
@RestController
@RequestMapping("/ribbon")
public class OrderController {
    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String testRibbon(){
        return "port:"+port;
    }

    @GetMapping(value = "/r1")
//    标记拥有p1权限方可访问此url
//    @PreAuthorize("hasAnyAuthority()")
    @PreAuthorize("hasAuthority('P2')")
    public String r1(){
        return "访问order资源";
    }
}
