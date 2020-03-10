package com.falynsky.financial_organizer.model.DTO;

public class BankAccountTypesDTO {

    private Integer bankAccountTypeId;
    private String name;

    public BankAccountTypesDTO(Integer bankAccountTypeId, String name) {
        this.bankAccountTypeId = bankAccountTypeId;
        this.name = name;
    }

    public Integer getBankAccountTypeId() {
        return bankAccountTypeId;
    }

    public String getName() {
        return name;
    }
}
