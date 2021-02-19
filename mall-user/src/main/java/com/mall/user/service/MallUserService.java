package com.mall.user.service;


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
     * 查询用户信息
     * @param mallUser 查询条件
     * @return List<MallUser>
     */
    MallUser queryMallUser(MallUser mallUser);
}
