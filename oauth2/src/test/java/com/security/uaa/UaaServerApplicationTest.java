package com.security.uaa;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author: gaolingfeng
 * @date: 2020/12/27 17:56
 * @description:
 */
@SpringBootTest
public class UaaServerApplicationTest {

    /**
     * springSecurity加密测试
     * @author: gaolingfeng
     * @date: 2020/12/27 17:58
     * @param
     * @return
     */

    @Test
    public void test01(){
        String client_secret = "secret";
        System.out.print("客户端密钥"+client_secret+"加密后为");
    }
}
