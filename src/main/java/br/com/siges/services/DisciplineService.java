package br.com.siges.services;

import br.com.siges.models.String;
import br.com.siges.repositories.DisciplineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplineService {
    @Autowired
    DisciplineRepository disciplineRepository;
    public String save(String discipline){

        return disciplineRepository.save(discipline);
    }

    public List<String> listAll(){

        return disciplineRepository.findAll();
    }
}
