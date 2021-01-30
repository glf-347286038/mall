package com.mall.user.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 返回消息统一格式
 * @author: gaolingfeng
 * @date: 2021/1/17 22:04
 * @description:
 */
@Data
public class ResponseData<T> implements Serializable {
    private static final long serialVersionUID = -20210123224750L;
    @ApiModelProperty(value = "是否成功,默认true")
    private Boolean success = true;
    @ApiModelProperty(value = "返回码")
    private Integer code = 200;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private T data;
}
