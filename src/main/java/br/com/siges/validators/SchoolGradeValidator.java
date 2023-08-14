package br.com.siges.validators;

import jakarta.validation.constraints.*;

public class SchoolGradeValidator {
    @NotNull
    @NotBlank
    @Size(min = 3, max = 64)
    private String name;
    @Min(3)
    @Max(16)
    private int sequence;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
}
