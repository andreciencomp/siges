package br.com.siges.services;

import br.com.siges.models.SchoolGrade;
import br.com.siges.models.Student;
import br.com.siges.repositories.SchoolGradeRepository;
import br.com.siges.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SchoolGradeRepository schoolGradeRepository;

    public Student save(Student student, long idSchoolGrade){

        SchoolGrade schoolGrade = schoolGradeRepository.findById(idSchoolGrade).orElseThrow();
        student.setCurrentSchoolGrade(schoolGrade);
        return studentRepository.save(student);
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
}
