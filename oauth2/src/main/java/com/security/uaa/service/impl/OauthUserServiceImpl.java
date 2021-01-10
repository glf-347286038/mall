package com.security.uaa.service.impl;

import com.security.uaa.mapper.OauthUserMapper;
import com.security.uaa.model.entity.OauthUser;
import com.security.uaa.service.OauthUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: gaolingfeng
 * @date: 2020/12/26 17:18
 * @description:
 */
@Service
@Slf4j
public class OauthUserServiceImpl implements OauthUserService {
    @Autowired
    private OauthUserMapper oauthUserMapper;

    @Override
    public OauthUser getOauthUser(OauthUser oauthUser) {
        return null;
    }
}
