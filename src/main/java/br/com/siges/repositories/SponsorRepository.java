package br.com.siges.repositories;

import br.com.siges.models.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SponsorRepository extends JpaRepository<Sponsor, Long> {

    public Optional<Sponsor> findByCpf(String cpf);
}
