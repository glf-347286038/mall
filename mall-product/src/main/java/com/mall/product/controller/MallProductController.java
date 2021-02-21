package com.mall.product.controller;

import com.mall.product.model.dto.MallProductDTO;
import com.mall.product.service.MallProductService;
import com.mall.product.util.ResponseData;
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

    @ApiOperation(value = "查询商品")
    @PostMapping(value = "/queryProduct", produces = "application/json;charset=UTF-8")
    public ResponseData<List<MallProductDTO>> queryProduct(@RequestBody MallProductDTO mallProductDTO) {
        log.info("MallProductController queryProduct {}",mallProductDTO);
        ResponseData<List<MallProductDTO>> responseData = new ResponseData<>();
        try {
            responseData.setData(mallProductService.queryProduct(mallProductDTO));
        } catch (Exception e) {
            log.error("MallProductController queryProduct {},{}", e.getMessage(),e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }
}
