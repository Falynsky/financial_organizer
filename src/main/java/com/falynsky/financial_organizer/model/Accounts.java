package com.falynsky.financial_organizer.model;

import javax.persistence.*;

@Entity
public class Accounts {
    private Integer accountId;
    private String login;
    private String password;
    private AccountTypes accountTypesByAccountTypeId;
    private Subjects subjectId;

    @Id
    @Column(name = "account_id", nullable = false)
    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Basic
    @Column(name = "login", nullable = false, length = 45)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Accounts accounts = (Accounts) o;

        if (accountId != null ? !accountId.equals(accounts.accountId) : accounts.accountId != null) return false;
        if (login != null ? !login.equals(accounts.login) : accounts.login != null) return false;
        if (password != null ? !password.equals(accounts.password) : accounts.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId != null ? accountId.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "account_type_id", referencedColumnName = "account_type_id", nullable = false)
    public AccountTypes getAccountTypesByAccountTypeId() {
        return accountTypesByAccountTypeId;
    }

    public void setAccountTypesByAccountTypeId(AccountTypes accountTypesByAccountTypeId) {
        this.accountTypesByAccountTypeId = accountTypesByAccountTypeId;
    }

    @OneToOne
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id", nullable = false)
    public Subjects getSubjectsBySubjectId() {
        return subjectId;
    }

    public void setSubjectsBySubjectId(Subjects subjectId) {
        this.subjectId = subjectId;
    }
}
