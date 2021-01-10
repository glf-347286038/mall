package com.security.uaa.service;

import com.security.uaa.model.entity.OauthUser;

/**
 * description:
 * @author: gaolingfeng
 * @date: 2020/12/26 17:13
 */
public interface OauthUserService {
    /**
     * 根据userName、userId查找用户信息
     * @author: gaolingfeng
     * @date: 2020/12/26 17:16
     * @param oauthUser userId userName
     * @return Oauth2User
     */
    OauthUser getOauthUser(OauthUser oauthUser);
}
