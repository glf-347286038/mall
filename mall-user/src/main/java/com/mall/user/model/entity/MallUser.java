package com.mall.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@Accessors(chain = true)
public class MallUser implements Serializable {

    private static final long serialVersionUID = 20210224210314L;

    @TableId("USER_ID")
    @ApiModelProperty(value = "用户唯一ID")
    private Integer userId;

    /**
     * 用户登录名
     */
    @ApiModelProperty("")
    private String userName;

    /**
     * 用户真实姓名
     */
    @ApiModelProperty("")
    private String realName;

    /**
     * 手机号
     */
    @ApiModelProperty("")
    private String phone;

    /**
     * 性别
     */
    @ApiModelProperty("")
    private String sex;

    /**
     * 年龄
     */
    @ApiModelProperty("")
    private Integer age;

    @ApiModelProperty("")
    private Integer accountId;

    /**
     * 创建日期
     */
    @ApiModelProperty("")
    private LocalDateTime creationDate;

    /**
     * 创建人id
     */
    @ApiModelProperty("")
    private Integer createdBy;

    /**
     * 最近更新日期
     */
    @ApiModelProperty("")
    private LocalDateTime lastUpdateDate;

    /**
     * 最近更新人id
     */
    @ApiModelProperty("")
    private Integer lastUpdateBy;

    /**
     * 更新版本号
     */
    @ApiModelProperty("")
    private Integer versionNumber;

}
