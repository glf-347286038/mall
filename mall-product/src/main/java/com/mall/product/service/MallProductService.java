package com.mall.product.service;

import com.mall.product.model.dto.MallUserDTO;
import com.mall.product.common.util.Pagination;
import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.model.dto.ProductRequestDTO;

import java.util.List;

/**
 * @author gaolingfeng
 */
public interface MallProductService {

    /**
     * 商品页面初始化加载逻辑redis+mysql
     * @author: gaolingfeng
     * @date: 2021/2/26 17:50
     * @param pagination 分页
     * @return List<MallProductDTO>
     */
//    Page<MallProductDTO> indexShowProduct(Pagination pagination);

    /**
     * 查询商品信息
     * @author: gaolingfeng
     * @date: 2021/2/27 23:14
     * @param  productRequestDTO 查询条件
     * @return Pagination
     */
    Pagination queryProduct(ProductRequestDTO productRequestDTO);

    /**
     * 查询用户余额
     * @param userId 用户id
     * @return Integer 用户余额
     */
    MallUserDTO getUserBalance(Integer userId);

    /**
     * 最原版不分页
     * @author: gaolingfeng
     * @date: 2021/2/28 1:39
     * @param mallProductDTO 参数
     * @return List
     */
    List<MallProductDTO> queryProductL(MallProductDTO mallProductDTO);
}
