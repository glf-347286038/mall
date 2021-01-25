package com.security.uaa.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.security.uaa.model.entity.OauthUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gaolingfeng
 */
@Mapper
public interface OauthUserMapper extends BaseMapper<OauthUser> {

    /**
     * 查找所有信息
     *
     * @param oauthUser
     * @return
     * @author: gaolingfeng
     * @date: 2020/12/25 14:34
     */
    List<OauthUser> queryOauthUser(@Param("oauthUser") OauthUser oauthUser);

    /**
     * 根据用户id或者name查询权限等级
     *
     * @param oauthUser 1
     * @return
     * @author: gaolingfeng
     * @date: 2020/12/27 0:59
     */
    List<String> queryPermissionDetail(OauthUser oauthUser);
}
