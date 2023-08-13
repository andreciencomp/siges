package br.com.siges.repositories;

import br.com.siges.models.String;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DisciplineRepository extends JpaRepository<String, Long> {
}
