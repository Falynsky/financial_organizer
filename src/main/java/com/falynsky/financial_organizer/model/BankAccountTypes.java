package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_account_types", schema = "financial_organizer")
public class BankAccountTypes {
    private Integer bankAccountTypesId;
    private String name;

    @Id
    @Column(name = "bank_account_types_id", nullable = false)
    public Integer getBankAccountTypesId() {
        return bankAccountTypesId;
    }

    public void setBankAccountTypesId(Integer bankAccountTypesId) {
        this.bankAccountTypesId = bankAccountTypesId;
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

        if (bankAccountTypesId != null ? !bankAccountTypesId.equals(that.bankAccountTypesId) : that.bankAccountTypesId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankAccountTypesId != null ? bankAccountTypesId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
