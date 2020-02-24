package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
public class Loans {
    private Integer loanId;
    private String name;
    private Double value;
    private Accounts accountsByAccountId;
    private LoanTypes loanTypeId;

    @Id
    @Column(name = "loan_id", nullable = false)
    public Integer getLoanId() {
        return loanId;
    }

    public void setLoanId(Integer loanId) {
        this.loanId = loanId;
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
    @Column(name = "value", nullable = true, precision = 0)
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Loans loans = (Loans) o;

        if (loanId != null ? !loanId.equals(loans.loanId) : loans.loanId != null) return false;
        if (name != null ? !name.equals(loans.name) : loans.name != null) return false;
        if (value != null ? !value.equals(loans.value) : loans.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loanId != null ? loanId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_id", nullable = false)
    public Accounts getAccountsByAccountId() {
        return accountsByAccountId;
    }

    public void setAccountsByAccountId(Accounts accountsByAccountId) {
        this.accountsByAccountId = accountsByAccountId;
    }

    @ManyToOne
    @JoinColumn(name = "loan_type_id", referencedColumnName = "loan_type_id", nullable = false)
    public LoanTypes getLoanTypesByLoanTypesId() {
        return loanTypeId;
    }

    public void setLoanTypesByLoanTypesId(LoanTypes loanTypeId) {
        this.loanTypeId = loanTypeId;
    }
}
