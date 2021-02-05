package com.mall.user.controller;

import com.mall.user.model.dto.TestRequestMethodDTO;
import com.mall.user.service.TestService;
import com.mall.user.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private TestService testService;

    /**
     * raw user of parameterized class 'xxx'
     * 泛型不要使用原生态类型 会导致丢失类型安全性
     * ResponseData会警告 所以Response要在方法中new一个新的即使代码重复
     */

    @ApiOperation(value = "测试访问权限")
    @GetMapping(value = "/grant")
    @PreAuthorize("hasAuthority('P2')")
    public String testGrant() {
        log.info("TestController testGrant");
        ResponseData<String> responseData = new ResponseData<>();
        try {
            responseData.setData("此人拥有p2权限");
        } catch (Exception e) {
            log.error("TestController testGrant{}", e.getMessage(), e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return "访问order资源";
    }

    @ApiOperation(value = "测试")
    @GetMapping(value = "/test", produces = "application/json;charset=UTF-8")
    public ResponseData<String> test() {
        log.info("TestController refreshToken");
        ResponseData<String> responseData = new ResponseData<>();
        try {
            responseData.setData("成功");
        } catch (Exception e) {
            log.error("TestController test{},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "测试访问权限")
    @GetMapping(value = "/p3", produces = "application/json;charset=UTF-8")
    @PreAuthorize("hasAuthority('P2')")
    public String r1() {
        return "访问order资源";
    }


    @ApiOperation(value = "测试get请求返回List")
    @GetMapping(value = "/testGet", produces = "application/json;charset=UTF-8")
    public ResponseData<List<TestRequestMethodDTO>> testGet(String name, Integer age) {
        log.info("TestController testGet{},{}", name, age);
        ResponseData<List<TestRequestMethodDTO>> responseData = new ResponseData<>();
        try {
            responseData.setData(testService.testGet(name, age));
        } catch (Exception e) {
            log.error("TestController testGet{},{}", e.getMessage(),e);
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }


    @ApiOperation(value = "测试post请求")
    @PostMapping(value = "/testPost", produces = "application/json;charset=UTF-8")
    public ResponseData<TestRequestMethodDTO> testPost(@RequestBody TestRequestMethodDTO requestMethodDTO) {
        log.info("TestController testPut{}", requestMethodDTO);
        ResponseData<TestRequestMethodDTO> responseData = new ResponseData<>();
        try {
            responseData.setData(testService.testPost(requestMethodDTO));
        } catch (Exception e) {
            log.error("TestController testPut{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "测试put请求")
    @GetMapping(value = "/testPut", produces = "application/json;charset=UTF-8")
    public ResponseData<TestRequestMethodDTO> testPut(@RequestBody TestRequestMethodDTO requestMethodDTO) {
        log.info("TestController testPut{}", requestMethodDTO);
        ResponseData<TestRequestMethodDTO> responseData = new ResponseData<>();
        try {
            responseData.setData(testService.testPut(requestMethodDTO));
        } catch (Exception e) {
            log.error("TestController testPut{},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    /**
     * 经测试
     * @param key
     * @return
     */
    @ApiOperation(value = "测试异常机制")
    @GetMapping(value = "/testError", produces = "application/json;charset=UTF-8")
    public ResponseData<String> testError(String key) {
        log.info("TestController testError{}", key);
        ResponseData<String> responseData = new ResponseData<>();
        try {
            responseData.setData(testService.testError(key));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(e.toString());
            log.error("<====TestController-testError error: {}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "测试不捕获异常")
    @GetMapping(value = "/testNoCatch", produces = "application/json;charset=UTF-8")
    public ResponseData<String> testNoCatch() throws Exception {
        log.info("TestController testNoCatch");
        ResponseData<String> responseData = new ResponseData<>();
        responseData.setData(testService.testNoCatch());
        return responseData;
    }

}
