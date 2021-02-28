package com.mall.user.model.dto;

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
public class UserAddressDTO implements Serializable {

    private static final long serialVersionUID = 20210228173947L;

    @ApiModelProperty(value = "用户地址唯一ID")
    private Integer addressId;

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
}
