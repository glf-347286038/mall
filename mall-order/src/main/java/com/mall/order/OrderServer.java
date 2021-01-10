package com.mall.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.core.annotation.Order;

/**
 * @author gaolingfeng
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
@EnableFeignClients
public class OrderServer {
    public static void main(String[] args){
        SpringApplication.run(OrderServer.class,args);
    }
}
