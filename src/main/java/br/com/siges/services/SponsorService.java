package br.com.siges.services;

import br.com.siges.models.Sponsor;
import br.com.siges.repositories.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SponsorService {
    @Autowired
    SponsorRepository sponsorRepository;
    Sponsor findByCpf(String cpf){

        return sponsorRepository.findByCpf(cpf).orElse(null);

    }
}
