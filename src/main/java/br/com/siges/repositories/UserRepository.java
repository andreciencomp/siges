package br.com.siges.repositories;

import br.com.siges.models.User;
import org.springframework.data.repository.Repository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface UserRepository extends Repository<User, Long> {

    Optional<User> findByUsername(String username);

}
