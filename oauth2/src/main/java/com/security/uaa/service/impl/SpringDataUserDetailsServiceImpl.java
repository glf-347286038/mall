package com.security.uaa.service.impl;

import com.security.uaa.mapper.OauthUserMapper;
import com.security.uaa.model.entity.OauthUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: gaolingfeng
 * @date: 2020/12/23 22:53
 * @description:
 */
@Service
public class SpringDataUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private OauthUserMapper oauthUserMapper;

    /**
     * 根据账号查询用户信息
     *
     * @param userName
     * @author: gaolingfeng
     * @date: 2020/12/23 22:54
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        System.out.println("secret:" + passwordEncoder.encode("secret"));
        //去根据用户名去数据库中查找
        List<OauthUser> oauthUserList = oauthUserMapper.queryOauthUser(new OauthUser() {
            {
                setUserName(userName);
            }
        });

        if (CollectionUtils.isEmpty(oauthUserList)) {
            //如果用户查不到 由provider来抛出异常
            return null;
        }
        OauthUser oauthUser = oauthUserList.get(0);

        //查询用户权限列表
        List<String> permissionList = oauthUserMapper.queryPermissionDetail(oauthUser);
        //将List转为Array
        String[] permissionArray = permissionList.toArray(new String[permissionList.size()]);

        /**
         * userDTO.setPermission(passwordEncoder.encode(userDTO.getPermission()));
         * UserDetails userDetails = User.withUsername(userDTO.getUserName()).
         * password(userDTO.getPassWord()).authorities(permissionArray).build();
         */

        UserDetails userDetails = User.withUsername(oauthUser.getUserName()).password(oauthUser.getPassword()).
                authorities(permissionArray).build();
        return userDetails;
    }
}
