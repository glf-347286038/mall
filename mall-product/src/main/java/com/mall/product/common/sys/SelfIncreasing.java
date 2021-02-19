package com.mall.product.common.sys;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * @author: gaolingfeng
 * @date: 2021/2/7 19:19
 * 获得自增列数字
 */
@Component
public class SelfIncreasing {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 获得表自增列的下一值
     *
     * @param tableName  表名
     * @param columnName 列名
     * @return Integer 下一值
     */
    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public Integer getNextKey(String tableName, String columnName) {
        if (StringUtils.isEmpty(tableName)) {
            throw new DataAccessResourceFailureException("必须设置表名");
        }
        if (StringUtils.isEmpty(columnName)) {
            throw new DataAccessResourceFailureException("必须设置列名");
        }

        Map<String, Object> currentValueMap = jdbcTemplate
                .queryForMap("SELECT CURRENT_VALUE FROM self_increasing WHERE TABLE_NAME = '" + tableName + "' AND COLUMN_NAME = '" + columnName + "'");
        if (CollectionUtils.isEmpty(currentValueMap)) {
            throw new DataAccessResourceFailureException("程序出错，请联系管理员");
        }
        // 表自增列的下一值
        Integer nextId = (Integer) currentValueMap.get("CURRENT_VALUE") + 1;
        // 更新自增表的下一值
        jdbcTemplate.update(" UPDATE self_increasing SET CURRENT_VALUE='" + nextId + "' WHERE TABLE_NAME ='" + tableName + "' AND COLUMN_NAME = '" + columnName + "'");
        return nextId;
    }
}
