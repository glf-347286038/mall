package com.mall.product.common.sys;

import lombok.Data;

/**
 * @author: gaolingfeng
 * @date: 2021/1/30 17:35
 * 自定义异常类
 * 编译时异常就继承Exception 调用时就必须进行处理或者在方法上抛出
 * 运行时异常就继承RuntimeException,调用时可以不处理
 */
@Data
public class MallException extends RuntimeException{
    private String code;

    public MallException(){
        super();
    }

    public MallException(String message){
        super(message);
    }

    public MallException(String code,String message){
        super(message);
        this.code = code;
    }

}
