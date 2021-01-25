package com.security.uaa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author gaolingfeng
 * @Date 2020-12-21
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
@EnableFeignClients
@MapperScan("com.security.uaa.mapper")
public class UaaServer {
    public static void main(String[] args) {
        SpringApplication.run(UaaServer.class, args);
    }
}
