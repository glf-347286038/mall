package com.mall.user.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;

/**
 * @author: gaolingfeng
 * @date: 2021/2/25 22:23
 * mybatisPlus配置类
 */
public class MybatisPlusConfig {
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
