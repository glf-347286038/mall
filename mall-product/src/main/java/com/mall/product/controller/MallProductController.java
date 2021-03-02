package com.mall.product.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mall.product.model.dto.MallUserDTO;
import com.mall.product.common.util.Pagination;
import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.model.dto.ProductRequestDTO;
import com.mall.product.service.MallProductService;
import com.mall.product.common.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/19 22:52
 * @description:
 */
@Api(tags = "productController")
@RestController
@RequestMapping(value = "mallProduct")
@Slf4j
public class MallProductController {
    @Autowired
    private MallProductService mallProductService;

    @ApiOperation(value = "查询商品分页")
    @PostMapping(value = "/queryProduct", produces = "application/json;charset=UTF-8")
    public ResponseData<Pagination> queryProduct(@RequestBody ProductRequestDTO dto) {
        log.info("MallProductController queryProduct {} ",dto);
        ResponseData<Pagination> responseData = new ResponseData<>();
        try {
            responseData.setData(mallProductService.queryProduct(dto));
        } catch (Exception e) {
            log.error("MallProductController queryProduct {},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "查询用户余额,地址")
    @GetMapping(value = "/getBalance", produces = "application/json;charset=UTF-8")
    public ResponseData<MallUserDTO> getBalance(@RequestParam("userId") Integer userId) {
        log.info("MallProductController queryBalance {} ",userId);
        ResponseData<MallUserDTO> responseData = new ResponseData<>();
        try {
            responseData.setData(mallProductService.getUserBalance(userId));
        } catch (Exception e) {
            log.error("MallProductController queryBalance {},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "首页展示商品")
    @PostMapping(value = "/indexShowProduct", produces = "application/json;charset=UTF-8")
    public ResponseData<Page<MallProductDTO>> indexShowProduct(Pagination pagination) {
        log.info("MallProductController indexShowProduct {}", pagination);
        ResponseData<Page<MallProductDTO>> responseData = new ResponseData<>();
        try {
//            responseData.setData(mallProductService.indexShowProduct(pagination));
        } catch (Exception e) {
            log.error("MallProductController indexShowProduct {},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "查询商品不分页")
    @PostMapping(value = "/queryProductL", produces = "application/json;charset=UTF-8")
    public ResponseData<List<MallProductDTO>> queryProduct(@RequestBody MallProductDTO mallProductDTO) {
        log.info("MallProductController queryProduct {}",mallProductDTO);
        ResponseData<List<MallProductDTO>> responseData = new ResponseData<>();
        try {
            responseData.setData(mallProductService.queryProductL(mallProductDTO));
            System.out.println("");
        } catch (Exception e) {
            log.error("MallProductController queryProduct {},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }
}
