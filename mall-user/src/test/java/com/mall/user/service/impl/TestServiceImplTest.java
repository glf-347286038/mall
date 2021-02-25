package com.mall.user.service.impl;

import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.model.entity.MallUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

class TestServiceImplTest {

    @Test
    void testGet() {
    }

    @Test
    void testPost() {
    }

    @Test
    void testPut() {
        BigDecimal b = BigDecimal.valueOf(0.9876);
        System.out.println(b.multiply(BigDecimal.valueOf(100)).stripTrailingZeros());
        System.out.println(b.multiply(BigDecimal.valueOf(100)).stripTrailingZeros()+"%");
        System.out.println(null+"%");

        BigDecimal c = null;
        System.out.println(c==null);

        System.out.println(BigDecimal.valueOf(0).multiply(BigDecimal.valueOf(11)));

        BigDecimal cc = BigDecimal.valueOf(0.5000);
        BigDecimal cc2 = cc.multiply(BigDecimal.valueOf(100)).stripTrailingZeros();
        System.out.println(cc2.toPlainString()+"%");
        System.out.println(cc.multiply(BigDecimal.valueOf(100)));


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
                break;
            default:
        }
    }

    @Test
    void testBanUtils() {
        MallUser mallUser = new MallUser();
        mallUser.setAccountId(1);
        mallUser.setUserName("SS");

        MallUserDTO mallUserDTO = new MallUserDTO();
        BeanUtils.copyProperties(mallUser,mallUserDTO);
        System.out.println(mallUserDTO);
    }
}