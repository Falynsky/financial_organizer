package com.falynsky.financial_organizer.model.DTO;

public class AccountTypesDTO {

    private Integer accountTypeId;
    private String name;
    private Integer permissionLevel;

    public AccountTypesDTO(Integer accountTypeId, String name, Integer permissionLevel) {
        this.accountTypeId = accountTypeId;
        this.name = name;
        this.permissionLevel = permissionLevel;
    }

    public Integer getAccountTypeId() {
        return accountTypeId;
    }

    public String getName() {
        return name;
    }

    public Integer getPermissionLevel() {
        return permissionLevel;
    }
}
