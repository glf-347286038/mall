package com.mall.user.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author gaolingfeng
 * @since 2021-02-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 20210224222414L;

    /**
     * 账户ID
     */
    @TableId("ACCOUNT_ID")
    private Integer accountId;


    /**
     * 余额
     */
    @TableField("BALANCE")
    private BigDecimal balance;

    /**
     * 支付密码
     */
    @TableField("ACCOUNT_PASSWORD")
    private String accountPassword;

    /**
     * 创建日期
     */
    @TableField("CREATION_DATE")
    private LocalDateTime creationDate;

    /**
     * 创建人id
     */
    @TableField("CREATED_BY")
    private Integer createdBy;

    /**
     * 最近更新日期
     */
    @TableField("LAST_UPDATE_DATE")
    private LocalDateTime lastUpdateDate;

    /**
     * 最近更新人id
     */
    @TableField("LAST_UPDATE_BY")
    private Integer lastUpdateBy;

    /**
     * 更新版本号
     */
    @TableField("VERSION_NUMBER")
    private Integer versionNumber;


}
