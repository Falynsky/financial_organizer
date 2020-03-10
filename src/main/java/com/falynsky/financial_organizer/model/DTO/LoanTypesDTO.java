package com.falynsky.financial_organizer.model.DTO;

public class LoanTypesDTO {

    private Integer loanTypeId;
    private String name;

    public LoanTypesDTO(Integer loanTypeId, String name) {
        this.loanTypeId = loanTypeId;
        this.name = name;
    }

    public Integer getLoanTypeId() {
        return loanTypeId;
    }

    public String getName() {
        return name;
    }
}
