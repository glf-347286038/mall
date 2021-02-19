package com.mall.product.service.impl;

import com.mall.product.mapper.MallProductMapper;
import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.service.MallProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/19 22:48
 * @description:
 */
@Service
@Slf4j
public class MallProductServiceImpl implements MallProductService {
    @Autowired
    private MallProductMapper mallProductMapper;
    @Override
    public List<MallProductDTO> queryProduct(MallProductDTO mallProductDTO) {
        return mallProductMapper.queryProduct(mallProductDTO);
    }
}
