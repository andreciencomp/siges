package br.com.siges.services;

import br.com.siges.models.SchoolGrade;
import br.com.siges.repositories.SchoolGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolGradeService {
    @Autowired
    SchoolGradeRepository schoolGradeRepository;
    public SchoolGrade save(SchoolGrade schoolGrade){

        return schoolGradeRepository.save(schoolGrade);
    }
}
