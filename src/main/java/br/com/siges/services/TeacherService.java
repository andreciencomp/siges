package br.com.siges.services;

import br.com.siges.models.Teacher;
import br.com.siges.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;
    public Teacher save(Teacher teacher){

        return teacherRepository.save(teacher);
    }
}
