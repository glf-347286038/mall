package com.mall.product.common.util;

/**
 * feign接收实体类，使用泛型接收,因为接收到的是LinkedHashMap
 * @author: gaolingfeng
 * @date: 2021/3/1 20:57
 * @description:
 */
public class FeignResponseData<T> {

    private String code;
    private String message;

    private int status;
    private T data ;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
