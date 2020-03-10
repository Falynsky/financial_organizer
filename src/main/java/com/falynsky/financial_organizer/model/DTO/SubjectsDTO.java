package com.falynsky.financial_organizer.model.DTO;

public class SubjectsDTO {

    private Integer subjectId;
    private String forename;
    private String surename;
    private String email;

    public SubjectsDTO(Integer subjectId, String forename, String surename, String email) {
        this.subjectId = subjectId;
        this.forename = forename;
        this.surename = surename;
        this.email = email;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public String getForename() {
        return forename;
    }

    public String getSurename() {
        return surename;
    }

    public String getEmail() {
        return email;
    }
}
