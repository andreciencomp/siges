package br.com.siges.services;

import br.com.siges.models.Discipline;
import br.com.siges.repositories.DisciplineRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;
    public Discipline save(Discipline discipline){

        return disciplineRepository.save(discipline);
    }
    @Transactional
    public List<Discipline> listAll(){

        return disciplineRepository.findAll();
    }
}

