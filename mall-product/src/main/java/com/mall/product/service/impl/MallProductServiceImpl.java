package com.mall.product.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.product.client.MallUserServiceClient;
import com.mall.product.model.dto.MallUserDTO;
import com.mall.product.common.util.Pagination;
import com.mall.product.common.util.RedisUtils;
import com.mall.product.mapper.MallProductMapper;
import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.model.dto.ProductRequestDTO;
import com.mall.product.service.MallProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/19 22:48
 * @description:
 */
@Service
@Slf4j
public class MallProductServiceImpl implements MallProductService {
    public static final String REDIS_PREFIX = "mall-product:mall-product:productId";
    public static final String REDIS_USER_PREFIX = "mall-user:mall-user:userId";
    /**
     * redis查询的最小数量,小于10,则去mysql查
     */
    public static final int MIN_PRODUCT_NUM = 10;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private MallProductMapper mallProductMapper;
    @Autowired
    private MallUserServiceClient userServiceClient;




    @Override
    public Pagination queryProduct(ProductRequestDTO productRequestDTO) {
        Pagination pagination = new Pagination(productRequestDTO.getPageNumber(),productRequestDTO.getPageSize());
        pagination.setTotalAndTotalPage(mallProductMapper.selectCount());
        pagination.setRecords(mallProductMapper.queryProduct(productRequestDTO,pagination));
        return pagination;
    }

    @Override
    public MallUserDTO getUserBalance(Integer userId) {
        MallUserDTO mallUserDTO = new MallUserDTO();
        // 先查redis，没查到去mall-user微服务去获取 注意类的全路径要和存入的一致com.mall.user

        //MallUserDTO redisMallUserDTO = (MallUserDTO) JSON.parse(redisUtils.hashGet(REDIS_USER_PREFIX, String.valueOf(userId)).toString());
//        if(!ObjectUtils.isEmpty(redisMallUserDTO)){
//            BeanUtils.copyProperties(redisMallUserDTO,mallUserDTO);
//        }else {
//            mallUserDTO = userServiceClient.getUserInfo(userId).getData();
//            System.out.println(mallUserDTO.toString());
//        }
        MallUserDTO mallUserDTO1 = userServiceClient.getUserInfo(userId).getData();
        return userServiceClient.getUserInfo(userId).getData();
    }

    @Override
    public List<MallProductDTO> queryProductL(MallProductDTO mallProductDTO) {
       Pagination pagination = new Pagination();
       pagination.setFlag("N");
       return null;
    }

    //    @Override
//    public Page<MallProductDTO> indexShowProduct(Pagination pagination) {
//        // 商品页面初始化加载逻辑
//        // 首页默认展示最少10条商品
//        // 分页
//        Page<MallProductDTO> dtoPage = new Page<>();
//        // 先查redis所有商品
//        List<MallProductDTO> redisProduct = this.queryRedisProductInfo(pagination);
//        if (CollectionUtils.isEmpty(redisProduct)) {
//            // redis 没有查到值,去查mysql 将mysql值全部存入redis
//            List<MallProductDTO> mallProductDTOS = mallProductMapper.queryProduct(new MallProductDTO(),pagination);
//            if(CollectionUtils.isEmpty(mallProductDTOS)){
//                return dtoPage;
//            }
//            dtoPage.setRecords(mallProductDTOS);
//            dtoPage.setTotal(mallProductMapper.selectCount());
//            try {
//                long putNum = this.putAllProductInfoToRedis(mallProductDTOS);
//                log.info("往redis中存入商品数目为：{}", putNum);
//            } catch (Exception e) {
//                log.error("往redis中存入商品失败");
//            }
//        } else {
//            // redis中查到值，但数量太少,小于一页数量,继续向mysql中查
//            if (redisProduct.size() < pagination.getSize()) {
//                List<MallProductDTO> mallProductDTOS = mallProductMapper.queryProduct(new MallProductDTO(),pagination);
//                dtoPage.setRecords(mallProductDTOS);
//                dtoPage.setTotal(mallProductMapper.selectCount());
//                this.putAllProductInfoToRedis(mallProductDTOS);
//            } else {
//                // redis中数量够了，直接返回redis
//                dtoPage.setRecords(redisProduct);
//                dtoPage.setTotal(redisProduct.size());
//            }
//        }
//        return dtoPage;
//    }

    /**
     * 查询redis中所有的数据
     *
     * @return List<MallProductDTO>
     * @author: gaolingfeng
     * @date: 2021/2/26 0:53
     */
    public List<MallProductDTO> queryRedisProductInfo(Pagination pagination) {
        List<Object> productRedisInfo = redisUtils.listGet(REDIS_PREFIX, pagination.getStart(), pagination.getEnd());
        if(CollectionUtils.isEmpty(productRedisInfo)){
            return null;
        }
        List<MallProductDTO> mallProductDTOList = new ArrayList<>();
        MallProductDTO mallProductDTO = new MallProductDTO();
        for (MallProductDTO dto : (List<MallProductDTO>)productRedisInfo.get(0)) {
            BeanUtils.copyProperties(dto, mallProductDTO);
            mallProductDTOList.add(mallProductDTO);
        }
        return mallProductDTOList;
    }


    /**
     * 将商品list存入redis 多个
     * @param mallProductDTOS 商品list
     * @return long
     */
    public long putAllProductInfoToRedis(List<MallProductDTO> mallProductDTOS) {
        return redisUtils.listPushAll(REDIS_PREFIX, mallProductDTOS);
    }

    /**
     * 将商品list存入redis 多个
     * @param mallProductDTOS 商品list
     * @return long
     */
    public void putProductToRedis(List<MallProductDTO> mallProductDTOS){
        for(MallProductDTO dto:mallProductDTOS){

        }
    }

}
