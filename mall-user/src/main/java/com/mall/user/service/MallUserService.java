package com.mall.user.service;


import com.mall.user.model.dto.MallUserDTO;
import com.mall.user.model.entity.MallUser;

import java.util.List;

/**
 * @author gaolingfeng
 * @since 2021-02-05
 */
public interface MallUserService {
    /**
     * 新增用户信息
     *
     * @param mallUser 用户信息
     * @author: gaolingfeng
     * @date: 2021/2/7 19:09
     */
    void save(MallUser mallUser);

    /**
     * 删除用户
     *
     * @param mallUser 用户信息
     * @author: gaolingfeng
     * @date: 2021/2/7 19:10
     */
    void delete(MallUser mallUser);

    /**
     * 查询用户自身信息
     *
     * @param userId 用户id
     * @return MallUserDTO
     */
    MallUserDTO getUserSelfInfo(Integer userId);

    /**
     * 查询用户信息
     *
     * @param userId   查询条件
     * @param userName 用户名
     * @param realName 真实姓名
     * @param phone    手机号
     * @return List<MallUser>
     */
    List<MallUserDTO> queryUserInfo(Integer userId, String userName, String realName, String phone);

    /**
     * 存入用户信息到redis中
     *
     * @param mallUserDTO 用户信息
     */
    void insertUserInfoToRedis(MallUserDTO mallUserDTO);
}
