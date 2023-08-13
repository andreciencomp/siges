package br.com.siges.validators;

import br.com.siges.enums.RoleName;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserValidator {
    @NotBlank
    @NotNull
    @Size(min = 3, max = 16)
    private String username;
    @Email
    @NotNull
    @NotBlank
    private String email;
    @NotBlank
    @NotNull
    @Size(min = 5, max = 64)
    private String password;
    @NotNull
    private RoleName roleName;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }
}
