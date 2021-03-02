package com.mall.product.client;

import com.mall.product.common.util.FeignResponseData;
import com.mall.product.model.dto.MallUserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 请求用户微服务feign
 * @author: gaolingfeng
 * @date: 2021/2/28 23:25
 */
@FeignClient("mall-user-dev")
public interface MallUserServiceClient {
    /**
     * 获得用户信息
     * @author: gaolingfeng
     * @date: 2021/2/28 23:29
     * @param userId 用户id
     * @return MallUserDTO
     */
    @GetMapping("/mallUser/getUserSelfInfo")
    FeignResponseData<MallUserDTO> getUserInfo(@RequestParam("userId") Integer userId);
}
