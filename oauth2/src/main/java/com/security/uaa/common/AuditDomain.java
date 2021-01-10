package com.security.uaa.common;

import java.util.Date;

/**
 * @author: gaolingfeng
 * @date: 2020/12/25 15:59
 * @description:
 */
public abstract class AuditDomain {
    /**
     * creationDte 创建时间
     * createdBy   创建人id
     * lastUpdateDate  最后修改时间
     * lastUpdateBy    最后修改人
     * versionNumber   修改版本号
     */
    private Date creationDte;
    private Integer createdBy;
    private Date lastUpdateDate;
    private Integer lastUpdateBy;
    private Integer versionNumber;

    public Date getCreationDte() {
        return creationDte;
    }

    public void setCreationDte(Date creationDte) {
        this.creationDte = creationDte;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(Integer lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy;
    }

    public Integer getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(Integer versionNumber) {
        this.versionNumber = versionNumber;
    }
}