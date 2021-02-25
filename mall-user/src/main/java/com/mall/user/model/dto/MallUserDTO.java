package com.mall.user.model.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: gaolingfeng
 * @date: 2021/2/25 15:21
 * 用户信息dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MallUserDTO implements Serializable {
    private static final long serialVersionUID = 20210225182445L;
    @ApiModelProperty(value = "用户唯一ID")
    private Integer userId;

    @ApiModelProperty("用户登录名")
    private String userName;

    @ApiModelProperty("用户真实姓名")
    private String realName;

    @ApiModelProperty("手机号")
    private String phone;

    @ApiModelProperty("性别")
    private String sex;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("账户余额")
    private BigDecimal accountBalance;

    @ApiModelProperty("创建日期")
    private Date creationDate;

    @ApiModelProperty("创建人id")
    private Integer createdBy;

    @ApiModelProperty("最近更新日期")
    private Date lastUpdateDate;

    @ApiModelProperty("最近更新人")
    private Integer lastUpdateBy;

    @ApiModelProperty("更新版本号")
    private Integer versionNumber;

    public MallUserDTO(Integer userId, String userName, String realName, String phone) {
        this.userId = userId;
        this.userName = userName;
        this.realName = realName;
        this.phone = phone;
    }
}
