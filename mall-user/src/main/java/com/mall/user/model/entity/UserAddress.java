package com.mall.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class UserAddress implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户地址唯一ID
     */
    @TableId("ADDRESS_ID")
    private Integer addressId;

    /**
     * 用户ID
     */
    @TableField("USER_ID")
    private Integer userId;

    /**
     * 地址_省
     */
    @TableField("ADDRESS_PROVINCE")
    private String addressProvince;

    /**
     * 地址_市
     */
    @TableField("ADDRESS_CITY")
    private String addressCity;

    /**
     * 地址_区/县
     */
    @TableField("ADDRESS_DISTRICTORCOUNTY")
    private String addressDistrictorcounty;

    /**
     * 地址_街道/镇
     */
    @TableField("ADDRESS_STREETORTOWN")
    private String addressStreetortown;

    /**
     * 地址_详细地址
     */
    @TableField("ADDRESS_DETAILED")
    private String addressDetailed;

    /**
     * 是否为默认地址Y/N
     */
    @TableField("DEFAULT_FLAG")
    private String defaultFlag;

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
