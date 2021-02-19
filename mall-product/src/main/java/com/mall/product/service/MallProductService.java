package com.mall.product.service;

import com.mall.product.model.dto.MallProductDTO;

import java.util.List;

/**
 * @author gaolingfeng
 */
public interface MallProductService {
    /**
     * 查询商品信息
     * @author: gaolingfeng
     * @date: 2021/2/19 22:47
     * @param mallProductDTO 查询条件类
     * @return List<MallProductDTO>
     */
    List<MallProductDTO> queryProduct(MallProductDTO mallProductDTO);
}
