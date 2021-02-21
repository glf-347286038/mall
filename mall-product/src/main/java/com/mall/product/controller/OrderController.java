package com.mall.product.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: gaolingfeng
 * @date: 2020/02/20 22:49
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
}
