package com.mall.user.service.impl;

import com.mall.user.model.dto.TestRequestMethodDTO;
import com.mall.user.service.TestService;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/1/28 14:45
 * @description:
 */
@Service
public class TestServiceImpl implements TestService {

    @Override
    public List<TestRequestMethodDTO> testGet(String name, Integer age) {
        List<TestRequestMethodDTO> requestMethodDTOS = new LinkedList<>();
        switch (name) {
            case "高":
                requestMethodDTOS.add(new TestRequestMethodDTO("高凌峰", 13));
                requestMethodDTOS.add(new TestRequestMethodDTO("高玲云", 19));
                break;
            case "李":
                requestMethodDTOS.add(new TestRequestMethodDTO("李磊", 21));
                requestMethodDTOS.add(new TestRequestMethodDTO("李欣", 24));
                break;
            default:
        }
        return requestMethodDTOS;
    }

    @Override
    public TestRequestMethodDTO testPost(TestRequestMethodDTO requestMethodDTO) {
        TestRequestMethodDTO testRequestMethodDTO = new TestRequestMethodDTO();
        testRequestMethodDTO.setName("峡谷城管");
        testRequestMethodDTO.setAge(18);
        return testRequestMethodDTO;
    }

    @Override
    public TestRequestMethodDTO testPut(TestRequestMethodDTO requestMethodDTO) {
        System.out.println(requestMethodDTO.toString());
        TestRequestMethodDTO testRequestMethodDTO = new TestRequestMethodDTO();
        testRequestMethodDTO.setName("峡谷城管");
        testRequestMethodDTO.setAge(18);
        return testRequestMethodDTO;
    }

    @Override
    public String testDelete(TestRequestMethodDTO requestMethodDTO) {
        return null;
    }

    @Override
    public String testError(String key) throws Exception {
        switch (key){
            case "空指针异常":
                String s = null;
                System.out.println(s.toUpperCase());
            case "手动抛错":
                throw new Exception("手动抛错");
            case "下标越界":
                int[] array = new int[2];
                System.out.println(array[3]);
                break;
            default:
        }
        return null;
    }

    @Override
    public String testNoCatch() throws Exception{
        throw new Exception("33333");
    }
}
