package com.mall.product.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author gaolingfeng
 * @date 2021-02-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class MallProductDTO implements Serializable {

    private static final long serialVersionUID = 20210218165465L;

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

    @ApiModelProperty(value = "商品图片地址(相对路径)")
    private String productImgPath;

    @ApiModelProperty(value = "秒杀开始时间")
    private Date rushStartTime;

    @ApiModelProperty(value = "秒杀结束时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") //入参
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")  //  出参数
    private Date rushEndTime;

    @ApiModelProperty(value = "商品库存")
    private Integer productStock;
}
