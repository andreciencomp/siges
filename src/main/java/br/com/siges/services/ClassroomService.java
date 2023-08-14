package br.com.siges.services;

import br.com.siges.enums.ClassroomStatus;
import br.com.siges.models.Classroom;
import br.com.siges.models.SchoolGrade;
import br.com.siges.repositories.ClassroomRepository;
import br.com.siges.repositories.SchoolGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class ClassroomService {

    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private SchoolGradeRepository schoolGradeRepository;

    public Classroom save(Classroom classroom, long idSchoolGrade){

        SchoolGrade sg = schoolGradeRepository.findById(idSchoolGrade).orElseThrow();
        classroom.setSchoolGrade(sg);
        classroom.setStatus(ClassroomStatus.OPEN);
        classroom.setYear(Year.now().getValue());
        return classroomRepository.save(classroom);
    }
}
