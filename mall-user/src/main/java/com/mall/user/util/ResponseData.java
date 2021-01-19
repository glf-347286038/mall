package com.mall.user.util;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回消息统一格式
 * @author: gaolingfeng
 * @date: 2021/1/17 22:04
 * @description:
 */
@Data
public class ResponseData {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;
    @ApiModelProperty(value = "返回码")
    private Integer code;
    @ApiModelProperty(value = "返回消息")
    private String message;
    @ApiModelProperty(value = "返回数据")
    private Map<String, Object> data = new HashMap<>();

    /**
     * 构造方法私有，单例模式
     */
    private ResponseData(){}

    private static ResponseData instance = new ResponseData();

    /**
     * 实例在初始化的时候就已经建好了，不管又没用用到，
     * 好处是没有线程安全问题，坏处是浪费内存空间
     */
    public static ResponseData getInstance(){
        return instance;
    }
}
