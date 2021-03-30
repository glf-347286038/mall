package com.mall.user.model.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 20210228173947L;

    @ApiModelProperty(value = "用户地址唯一ID")
    private Integer addressId;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "地址_省")
    private String addressProvince;

    @ApiModelProperty(value = "地址_市")
    private String addressCity;

    @ApiModelProperty(value = "地址_区/县")
    private String addressDistrictorcounty;

    @ApiModelProperty(value = "地址_街道/镇")
    private String addressStreetortown;

    @ApiModelProperty(value = "地址_详细地址")
    private String addressDetailed;

    @ApiModelProperty(value = "是否为默认地址Y/N")
    private String defaultFlag;

    @ApiModelProperty(value = "用户唯一ID")
    private LocalDateTime creationDate;

    @ApiModelProperty(value = "创建人id")
    private Integer createdBy;

    @ApiModelProperty(value = "最近更新日期")
    private LocalDateTime lastUpdateDate;

    @ApiModelProperty(value = "最近更新人id")
    private Integer lastUpdateBy;

    @ApiModelProperty(value = "更新版本号")
    private Integer versionNumber;
}
