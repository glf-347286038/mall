package com.mall.user.controller;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.mall.user.common.config.MyJwt;
import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.service.MallUserService;
import com.mall.user.util.ResponseData;
import com.netflix.discovery.converters.Auto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2021/2/25 20:34
 * @description:
 */
@Api(tags = "MallUserController")
@RestController
@RequestMapping(value = "mallUser")
@Slf4j
public class MallUserController {
    @Autowired
    private MallUserService mallUserService;

    @ApiOperation(value = "用户查询自己信息")
    @GetMapping(value = "/getUserSelfInfo")
    public ResponseData<MallUserDTO> getUserSelfInfo(@RequestParam("userId") Integer userId){
        log.info("<====MallUserController getUserSelfInfo {}",userId);
        ResponseData<MallUserDTO> responseData = new ResponseData<>();
        try {
            responseData.setData(mallUserService.getUserSelfInfo(userId));
        } catch (Exception e) {
            log.error("<====MallUserController getUserSelfInfo{}", e.getMessage(), e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }

    @ApiOperation(value = "查看所有用户信息S4权限")
    @GetMapping(value = "queryUserInfo")
    @PreAuthorize("hasAuthority('S4')")
    public ResponseData<List<MallUserDTO>> queryUserInfo(@RequestParam(value = "userId",required = false) Integer userId,
                                                         @RequestParam(value = "userName",required = false) String userName,
                                                         @RequestParam(value = "realName",required = false) String realName,
                                                         @RequestParam(value = "phone",required = false) String phone){
        log.info("<====MallUserController queryUserInfo {},{},{},{}",userId,userName,realName,phone);
        ResponseData<List<MallUserDTO>> responseData = new ResponseData<>();
        try {
            responseData.setData(mallUserService.queryUserInfo(userId,userName,realName,phone));
        } catch (Exception e) {
            log.error("<====MallUserController queryUserInfo{}", e.getMessage(), e);
            responseData.setMessage(e.getMessage());
            responseData.setSuccess(false);
        }
        return responseData;
    }
}
