package com.mall.product.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <p>
 * 自增列维护表
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SelfIncreasing implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 表名
     */
    @TableId("TABLE_NAME")
    private String tableName;

    /**
     * 列名
     */
    @TableField("COLUMN_NAME")
    private String columnName;

    /**
     * 当前值
     */
    @TableField("CURRENT_VALUE")
    private Long currentValue;


}
