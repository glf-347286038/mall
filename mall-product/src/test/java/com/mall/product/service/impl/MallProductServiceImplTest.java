package com.mall.product.service.impl;

import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.model.entity.MallProduct;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MallProductServiceImplTest {

    @Test
    void queryRedisProductInfo() {
        List<MallProductDTO> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            MallProductDTO mallProductDTO = new MallProductDTO();
            mallProductDTO.setProductId(i);
            list.add(mallProductDTO);
        }
        MallProduct mallProduct = new MallProduct();
        List<MallProduct> mallProducts = new ArrayList<>();
        for(MallProductDTO dto:list){
            BeanUtils.copyProperties(dto,mallProduct);
            mallProducts.add(mallProduct);
        }
        System.out.println(mallProducts);
    }

    @Test
    void indexShowProduct() {
        System.out.println(25/10 + 1);

        try {
            this.queryProduct();
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }

    @Test
    void queryProduct() {
        try {
            System.out.println(1/0);
        } catch (Exception e) {
            System.out.println("内层异常");
        }
    }
}