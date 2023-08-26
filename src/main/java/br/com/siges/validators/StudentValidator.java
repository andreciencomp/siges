package br.com.siges.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

public class StudentValidator {

    private long id;
    @NotNull
    @NotBlank
    @Size(min = 3, max=64)
    private String name;
    private String cpf;

    private List<SponsorValidator> sponsors;

    private long currentSchoolGrade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrentSchoolGrade() {
        return currentSchoolGrade;
    }

    public void setCurrentSchoolGrade(long currentSchoolGrade) {
        this.currentSchoolGrade = currentSchoolGrade;
    }

    public List<SponsorValidator> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<SponsorValidator> idSponsors) {
        this.sponsors = idSponsors;
    }
}
