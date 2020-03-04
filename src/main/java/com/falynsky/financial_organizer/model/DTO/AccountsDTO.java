package com.falynsky.financial_organizer.model.DTO;

public class AccountsDTO {

    private Integer accountId;
    private String login;
    private String password;
    private Integer accountTypesByAccountTypeId;
    private Integer subjectId;

    public AccountsDTO(Integer accountId, String login, String password, Integer accountTypesByAccountTypeId, Integer subjectId) {
        this.accountId = accountId;
        this.login = login;
        this.password = password;
        this.accountTypesByAccountTypeId = accountTypesByAccountTypeId;
        this.subjectId = subjectId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Integer getAccountTypesByAccountTypeId() {
        return accountTypesByAccountTypeId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }
}
