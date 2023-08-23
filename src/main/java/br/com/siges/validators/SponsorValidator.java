package br.com.siges.validators;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class SponsorValidator {
    @NotNull
    @NotBlank
    @Size(min=3, max=64)
    private String sponsorName;
    @NotNull
    @NotBlank
    private String sponsorCpf;

    public String getSponsorName() {
        return sponsorName;
    }

    public void setSponsorName(String sponsorName) {
        this.sponsorName = sponsorName;
    }

    public String getSponsorCpf() {
        return sponsorCpf;
    }

    public void setSponsorCpf(String sponsorCpf) {
        this.sponsorCpf = sponsorCpf;
    }
}
