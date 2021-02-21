package com.mall.product.model.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author gaolingfeng
 * @date 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MallProduct implements Serializable {

    private static final long serialVersionUID = 20210218165465L;

    @ApiModelProperty(value = "商品唯一ID")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品品牌")
    private String productBrand;

    @ApiModelProperty(value = "商品类别ID")
    private String productTypeId;

    @ApiModelProperty(value = "商品描述")
    private String productDescription;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "商品重量")
    private BigDecimal productWeight;

    @ApiModelProperty(value = "商品图片地址(相对路径)")
    private String productImgPath;

    @ApiModelProperty(value = "秒杀开始时间")
    private LocalDateTime rushStartTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private LocalDateTime rushEndTime;

    @ApiModelProperty(value = "商品库存")
    private Integer productStock;

    @ApiModelProperty(value = "创建日期")
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
