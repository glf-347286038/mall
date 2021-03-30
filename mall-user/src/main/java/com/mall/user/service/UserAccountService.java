package com.mall.user.service;

import com.mall.user.model.entity.UserAccount;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-24
 */
public interface UserAccountService {
    /**
     * 创建新账户
     * @author: gaolingfeng
     * @date: 2021/2/24 22:08
     * @param userAccount 对象
     * @return void
     */
    void createAccount(UserAccount userAccount);
}
