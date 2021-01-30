package com.mall.user.service.impl;

import org.junit.jupiter.api.Test;

class TestServiceImplTest {

    @Test
    void testGet() {
    }

    @Test
    void testPost() {
    }

    @Test
    void testPut() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void testError() throws Exception {
        String key = "下标越界";
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
    }
}