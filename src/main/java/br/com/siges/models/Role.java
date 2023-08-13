package br.com.siges.models;

import br.com.siges.enums.RoleName;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
@Entity
@Table(name="roles")
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Enumerated(EnumType.STRING)
    @Column(name="name", unique = true, nullable = false)
    private RoleName roleName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RoleName getRoleName() {
        return roleName;
    }

    public void setRoleName(RoleName roleName) {
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return roleName.toString();
    }
}
