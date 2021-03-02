package com.mall.product.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: gaolingfeng
 * @date: 2021/2/28 23:28
 * 用户信息dto
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MallUserDTO implements Serializable {
    private static final long serialVersionUID = 20210228232755L;
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

    @ApiModelProperty("收获地址")
    private String detailAddress;
}
