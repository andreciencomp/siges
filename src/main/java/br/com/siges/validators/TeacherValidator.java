package br.com.siges.validators;

import br.com.siges.models.Discipline;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class TeacherValidator {
    @NotNull
    @NotBlank
    private String name;

    private long[] eligibleDisciplines;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long[] getEligibleDisciplines() {
        return eligibleDisciplines;
    }

    public void setEligibleDisciplines(long[] eligibleDisciplines) {
        this.eligibleDisciplines = eligibleDisciplines;
    }
}

