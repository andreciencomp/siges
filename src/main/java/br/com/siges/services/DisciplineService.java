package br.com.siges.services;

import br.com.siges.models.Discipline;
import br.com.siges.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;
    public Discipline save(Discipline discipline){

        return disciplineRepository.save(discipline);
    }
}
