package br.com.siges.repositories;

import br.com.siges.enums.RoleName;
import br.com.siges.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Optional<Role> findByRoleName(RoleName roleName);
}
