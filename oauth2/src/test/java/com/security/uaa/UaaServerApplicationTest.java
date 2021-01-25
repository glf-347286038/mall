package com.security.uaa;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: gaolingfeng
 * @date: 2020/12/27 17:56
 * @description:
 */
@SpringBootTest
public class UaaServerApplicationTest {

    /**
     * springSecurity加密测试
     *
     * @param
     * @return
     * @author: gaolingfeng
     * @date: 2020/12/27 17:58
     */

    @Test
    public void test01() {
        String client_secret = "secret";
        System.out.print("客户端密钥" + client_secret + "加密后为");
    }
}
