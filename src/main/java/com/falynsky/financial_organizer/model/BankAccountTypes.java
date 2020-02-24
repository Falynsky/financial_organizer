package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_account_types", schema = "financial_organizer")
public class BankAccountTypes {
    private Integer bankAccountTypeId;
    private String name;

    @Id
    @Column(name = "bank_account_type_id", nullable = false)
    public Integer getBankAccountTypeId() {
        return bankAccountTypeId;
    }

    public void setBankAccountTypeId(Integer bankAccountTypeId) {
        this.bankAccountTypeId = bankAccountTypeId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccountTypes that = (BankAccountTypes) o;

        if (bankAccountTypeId != null ? !bankAccountTypeId.equals(that.bankAccountTypeId) : that.bankAccountTypeId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankAccountTypeId != null ? bankAccountTypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
