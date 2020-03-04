package com.falynsky.financial_organizer.model.DTO;

public class LoansDTO {

    private Integer loanId;
    private String name;
    private Double value;
    private Integer accountsByAccountId;
    private Integer loanTypeId;

    public LoansDTO(Integer loanId, String name, Double value, Integer accountsByAccountId, Integer loanTypeId) {
        this.loanId = loanId;
        this.name = name;
        this.value = value;
        this.accountsByAccountId = accountsByAccountId;
        this.loanTypeId = loanTypeId;
    }

    public Integer getLoanId() {
        return loanId;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }

    public Integer getAccountsByAccountId() {
        return accountsByAccountId;
    }

    public Integer getLoanTypeId() {
        return loanTypeId;
    }
}
