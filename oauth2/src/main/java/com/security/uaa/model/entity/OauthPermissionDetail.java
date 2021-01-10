package com.security.uaa.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.security.uaa.common.AuditDomain;
import lombok.Data;

/**
 * @author: gaolingfeng
 * @date: 2020/12/27 0:19
 * @description:
 */
@TableName(value = "oauth_permission_detail")
@Data
public class OauthPermissionDetail extends AuditDomain {
    @TableId(type = IdType.AUTO)
    private Integer permissionDetailId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 权限id
     */
    private Integer permissionId;
}
