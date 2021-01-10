package com.security.uaa.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.security.uaa.common.AuditDomain;

/**
 * @author: gaolingfeng
 * @date: 2020/12/25 11:35
 * @description:
 */
@TableName("oauth_user")
public class OauthUser extends AuditDomain {
    @TableId(type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String password;
    private String permission;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
