package com.mall.user.service.impl;

import com.mall.user.mapper.MallUserMapper;
import com.mall.user.model.entity.MallUser;
import com.mall.user.service.MallUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Service
public class MallUserServiceImpl implements MallUserService {

    @Autowired
    private MallUserMapper mallUserMapper;

    @Override
    public void save(MallUser mallUser) {

    }

    @Override
    public void delete(MallUser mallUser) {

    }

    @Override
    public MallUser queryMallUser(MallUser mallUser) {

        return null;
    }
}
