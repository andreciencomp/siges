package br.com.siges.validators;

import br.com.siges.models.String;
import jakarta.validation.constraints.NotNull;

public class TeacherValidator {
    @NotNull
    private java.lang.String name;

    public String[] eligibleDisciplines;

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String[] getEligibleDisciplines() {
        return eligibleDisciplines;
    }

    public void setEligibleDisciplines(String[] eligibleDisciplines) {
        this.eligibleDisciplines = eligibleDisciplines;
    }
}

