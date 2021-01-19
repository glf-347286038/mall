package com.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author gaolingfeng
 */
@SpringBootApplication
@EnableEurekaClient
//@EnableHystrix
@EnableFeignClients
public class UserServer {
    public static void main(String[] args){
        SpringApplication.run(UserServer.class,args);
    }
}
