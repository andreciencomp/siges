package br.com.siges.services;

import br.com.siges.exceptions.BDException;
import br.com.siges.models.Discipline;
import br.com.siges.models.Teacher;
import br.com.siges.repositories.DisciplineRepository;
import br.com.siges.repositories.TeacherRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    DisciplineRepository disciplineRepository;
    @Transactional
    public Teacher save(Teacher teacher, long[] disciplineIds) throws BDException{
        List<Discipline> eligibleDisciplines = new ArrayList<Discipline>();

        for(long id: disciplineIds){
            Discipline discipline = disciplineRepository.findById(id).orElseThrow(()-> new BDException());
            eligibleDisciplines.add(discipline);
        }
        teacher.setEligibleDisciplines(eligibleDisciplines);

        return teacherRepository.save(teacher);
    }
}
