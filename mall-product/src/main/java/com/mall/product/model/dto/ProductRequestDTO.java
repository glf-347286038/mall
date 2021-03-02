package com.mall.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mall.product.common.util.PageRequest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: gaolingfeng
 * @date: 2021/2/28 0:23
 * @description:
 */
@Data
@ApiModel(value = "商品页面请求dto")
public class ProductRequestDTO implements Serializable {
    private static final long serialVersionUID = 20210228013721L;

    @ApiModelProperty(value = "当前页")
    private Integer pageNumber;
    @ApiModelProperty(value = "页大小")
    private Integer pageSize;

    @ApiModelProperty(value = "商品唯一ID")
    private Integer productId;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品品牌")
    private String productBrand;

    @ApiModelProperty(value = "商品详细类别")
    private String Type;

    @ApiModelProperty(value = "商品描述")
    private String productDescription;

    @ApiModelProperty(value = "商品价格")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "最低价格")
    private BigDecimal lowestPrice;

    @ApiModelProperty(value = "最高价格")
    private BigDecimal highestPrice;

    @ApiModelProperty(value = "商品重量")
    private BigDecimal productWeight;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date rushStartTime;

    @ApiModelProperty(value = "秒杀结束时间")
    private Date rushEndTime;

    @ApiModelProperty(value = "商品库存")
    private Integer productStock;
}
