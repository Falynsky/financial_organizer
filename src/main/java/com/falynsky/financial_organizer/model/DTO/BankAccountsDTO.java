package com.falynsky.financial_organizer.model.DTO;

public class BankAccountsDTO {

    private Integer bankAccountId;
    private String name;
    private Double accountBalance;
    private Integer bankAccountTypesByBankAccountTypeId;
    private Integer accountsByAccountId;

    public BankAccountsDTO(Integer bankAccountId, String name, Double accountBalance, Integer bankAccountTypesByBankAccountTypeId, Integer accountsByAccountId) {
        this.bankAccountId = bankAccountId;
        this.name = name;
        this.accountBalance = accountBalance;
        this.bankAccountTypesByBankAccountTypeId = bankAccountTypesByBankAccountTypeId;
        this.accountsByAccountId = accountsByAccountId;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public String getName() {
        return name;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public Integer getBankAccountTypesByBankAccountTypeId() {
        return bankAccountTypesByBankAccountTypeId;
    }

    public Integer getAccountsByAccountId() {
        return accountsByAccountId;
    }
}
