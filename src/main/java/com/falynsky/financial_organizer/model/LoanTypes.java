package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
@Table(name = "loan_types", schema = "financial_organizer", catalog = "")
public class LoanTypes {
    private Integer loanTypeId;
    private String name;

    @Id
    @Column(name = "loan_type_id", nullable = false)
    public Integer getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(Integer loanTypeId) {
        this.loanTypeId = loanTypeId;
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

        LoanTypes loanTypes = (LoanTypes) o;

        if (loanTypeId != null ? !loanTypeId.equals(loanTypes.loanTypeId) : loanTypes.loanTypeId != null) return false;
        if (name != null ? !name.equals(loanTypes.name) : loanTypes.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loanTypeId != null ? loanTypeId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
