package br.com.siges.repositories;

import br.com.siges.models.SchoolGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolGradeRepository extends JpaRepository<SchoolGrade, Long> {
}
