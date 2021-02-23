package com.mall.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MallUser implements Serializable {

    private static final long serialVersionUID = 222L;

    @TableId("USER_ID")
    @ApiModelProperty(value = "用户唯一ID")
    private Integer userId;

    /**
     * 用户登录名
     */
    @TableField("USER_NAME")
    private String userName;

    /**
     * 用户真实姓名
     */
    @TableField("REAL_NAME")
    private String realName;

    /**
     * 手机号
     */
    @TableField("PHONE")
    private String phone;

    /**
     * 性别
     */
    @TableField("SEX")
    private String sex;

    /**
     * 年龄
     */
    @TableField("AGE")
    private Integer age;

    @TableField("SEX")
    private String balance;

    /**
     * 创建日期
     */
    @TableField("CREATION_DATE")
    private LocalDateTime creationDate;

    /**
     * 创建人id
     */
    @TableField("CREATED_BY")
    private Integer createdBy;

    /**
     * 最近更新日期
     */
    @TableField("LAST_UPDATE_DATE")
    private LocalDateTime lastUpdateDate;

    /**
     * 最近更新人id
     */
    @TableField("LAST_UPDATE_BY")
    private Integer lastUpdateBy;

    /**
     * 更新版本号
     */
    @TableField("VERSION_NUMBER")
    private Integer versionNumber;


}
