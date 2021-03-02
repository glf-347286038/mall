package com.mall.product.common.util;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: gaolingfeng
 * @date: 2021/2/27 23:34
 * @description:
 */
@Data
public class PageRequest implements Serializable {
    private int pageNumber;
    private int pageSize;
}
