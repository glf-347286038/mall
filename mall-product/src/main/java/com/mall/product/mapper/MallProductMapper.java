package com.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.product.model.dto.MallProductDTO;
import org.apache.ibatis.annotations.Mapper;
import com.mall.product.model.entity.MallProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  productMapper 接口
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-19
 */
@Mapper
public interface MallProductMapper extends BaseMapper<MallProduct> {
    /**
     * 查询商品信息
     * @author: gaolingfeng
     * @date: 2021/2/19 20:35
     * @param mallProductDTO 查询条件
     * @return List<MallProduct>
     */
    List<MallProductDTO> queryProduct(@Param("mallProductDTO")MallProductDTO mallProductDTO);
}
