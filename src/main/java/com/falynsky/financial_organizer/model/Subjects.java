package com.falynsky.financial_organizer.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Subjects {
    private Integer subjectId;
    private String forename;
    private String surename;
    private String email;

    @Id
    @Column(name = "subject_id", nullable = false)
    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Basic
    @Column(name = "forename", nullable = false, length = 225)
    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    @Basic
    @Column(name = "surename", nullable = false, length = 225)
    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 225)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subjects subjects = (Subjects) o;

        if (subjectId != null ? !subjectId.equals(subjects.subjectId) : subjects.subjectId != null) return false;
        if (forename != null ? !forename.equals(subjects.forename) : subjects.forename != null) return false;
        if (surename != null ? !surename.equals(subjects.surename) : subjects.surename != null) return false;
        if (email != null ? !email.equals(subjects.email) : subjects.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = subjectId != null ? subjectId.hashCode() : 0;
        result = 31 * result + (forename != null ? forename.hashCode() : 0);
        result = 31 * result + (surename != null ? surename.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
