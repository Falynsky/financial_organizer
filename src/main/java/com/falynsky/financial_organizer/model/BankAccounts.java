package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
@Table(name = "bank_accounts", schema = "financial_organizer", catalog = "")
public class BankAccounts {
    private Integer bankAccountId;
    private String name;
    private Double accountBalance;
    private BankAccountTypes bankAccountTypesByBankAccountTypeId;
    private Accounts accountsByAccountId;

    @Id
    @Column(name = "bank_account_id", nullable = false)
    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "account_balance", nullable = false, precision = 0)
    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankAccounts that = (BankAccounts) o;

        if (bankAccountId != null ? !bankAccountId.equals(that.bankAccountId) : that.bankAccountId != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (accountBalance != null ? !accountBalance.equals(that.accountBalance) : that.accountBalance != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bankAccountId != null ? bankAccountId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (accountBalance != null ? accountBalance.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "bank_account_type_id", referencedColumnName = "bank_account_types_id", nullable = false)
    public BankAccountTypes getBankAccountTypesByBankAccountTypeId() {
        return bankAccountTypesByBankAccountTypeId;
    }

    public void setBankAccountTypesByBankAccountTypeId(BankAccountTypes bankAccountTypesByBankAccountTypeId) {
        this.bankAccountTypesByBankAccountTypeId = bankAccountTypesByBankAccountTypeId;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    public Accounts getAccountsByAccountId() {
        return accountsByAccountId;
    }

    public void setAccountsByAccountId(Accounts accountsByAccountId) {
        this.accountsByAccountId = accountsByAccountId;
    }
}
