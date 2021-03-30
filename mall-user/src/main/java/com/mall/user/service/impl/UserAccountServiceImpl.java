package com.mall.user.service.impl;

import com.mall.user.common.sys.SelfIncreasingUtil;
import com.mall.user.mapper.UserAccountMapper;
import com.mall.user.model.entity.UserAccount;
import com.mall.user.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-24
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountMapper accountMapper;
    @Autowired
    private SelfIncreasingUtil selfIncreasingUtil;

    private static final String TABLE_NAME = "user_account";
    private static final String COLUMN_NAME = "ACCOUNT_ID";
    @Override
    public void createAccount(UserAccount userAccount) {

    }
}
