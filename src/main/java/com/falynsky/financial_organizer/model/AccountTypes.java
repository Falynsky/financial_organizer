package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
@Table(name = "account_types", schema = "financial_organizer", catalog = "")
public class AccountTypes {
    private Integer accountTypeId;
    private String name;
    private Integer permissionLevel;

    @Id
    @Column(name = "account_type_id", nullable = false)
    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Integer accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 225)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "permission_level", nullable = false)
    public Integer getPermissionLevel() {
        return permissionLevel;
    }

    public void setPermissionLevel(Integer permissionLevel) {
        this.permissionLevel = permissionLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountTypes that = (AccountTypes) o;

        if (accountTypeId != null ? !accountTypeId.equals(that.accountTypeId) : that.accountTypeId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (permissionLevel != null ? !permissionLevel.equals(that.permissionLevel) : that.permissionLevel != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountTypeId != null ? accountTypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (permissionLevel != null ? permissionLevel.hashCode() : 0);
        return result;
    }
}
