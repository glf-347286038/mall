package com.mall.user.service;

import com.mall.user.model.dto.TestRequestMethodDTO;

import java.util.List;

/**
 * @author gaolingfeng
 */
public interface TestService {

    /**
     * 测试get请求返回List<Object>
     *
     * @param name 名
     * @param age  年龄
     * @return List
     * @author: gaolingfeng
     * @date: 2021/1/28 23:49
     */
    List<TestRequestMethodDTO> testGet(String name, Integer age);

    /**
     * description: 测试post请求
     *
     * @param requestMethodDTO 请求对象
     * @return String
     * @author: gaolingfeng
     * @date: 2021/1/28 14:47
     */
    TestRequestMethodDTO testPost(TestRequestMethodDTO requestMethodDTO);

    /**
     * description: 测试put请求
     *
     * @param requestMethodDTO 请求对象
     * @return String
     * @author: gaolingfeng
     * @date: 2021/1/28 14:47
     */
    TestRequestMethodDTO testPut(TestRequestMethodDTO requestMethodDTO);

    /**
     * description: 测试delete请求
     *
     * @param requestMethodDTO 请求对象
     * @return String
     * @author: gaolingfeng
     * @date: 2021/1/28 14:47
     */
    String testDelete(TestRequestMethodDTO requestMethodDTO);

    /**
     * 测试抛错
     *
     * @author: gaolingfeng
     * @date: 2021/1/29 0:27
     * @param key 错误key
     * @return String
     * @throws Exception 抛错
     */
    String testError(String key) throws Exception;

    /**
     * 不捕获异常
     * @author: gaolingfeng
     * @date: 2021/1/29 21:21
     * @return String
     * @throws Exception
     */
    String testNoCatch() throws Exception;
}
