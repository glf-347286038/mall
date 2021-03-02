package com.mall.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mall.product.common.util.Pagination;
import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.model.dto.ProductRequestDTO;
import org.apache.ibatis.annotations.Mapper;
import com.mall.product.model.entity.MallProduct;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.PageRequest;

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
     * 查询所有数量
     * @author: gaolingfeng
     * @date: 2021/2/26 22:55
     * @return Integer
     */
    Integer selectCount();

    /**
     * 查询商品信息
     * @author: gaolingfeng
     * @date: 2021/2/19 20:35
     * @param mallProductDTO 查询条件
     * @param pagination 分页
     * @return List<MallProduct>
     */
    List<MallProductDTO> queryProduct(@Param("mallProductDTO") ProductRequestDTO mallProductDTO, @Param("pagination") Pagination pagination);
}
