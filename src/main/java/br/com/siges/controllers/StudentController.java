package br.com.siges.controllers;

import br.com.siges.models.SchoolGrade;
import br.com.siges.models.Sponsor;
import br.com.siges.models.Student;
import br.com.siges.services.SchoolGradeService;
import br.com.siges.services.StudentService;
import br.com.siges.validators.SponsorValidator;
import br.com.siges.validators.StudentValidator;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/app/students")
public class StudentController {

    @Autowired
    SchoolGradeService schoolGradeService;
    @Autowired
    StudentService studentService;
    @GetMapping("/create")
    public ModelAndView create(StudentValidator validator){
        ModelAndView mv = new ModelAndView("students/create");
        List<SchoolGrade> schoolGrades = schoolGradeService.listAll();
        mv.addObject("schoolGrades", schoolGrades);
        return mv;
    }

    @PostMapping("/save")
    @Transactional
    public ModelAndView save(@Valid StudentValidator validator, BindingResult result){


        Student student = new Student();
        ArrayList<Sponsor> sponsors = new ArrayList<Sponsor>();
        BeanUtils.copyProperties(validator, student);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student);
        for(SponsorValidator sponsorValidator: validator.getSponsors()){
            Sponsor sponsor = new Sponsor();
            BeanUtils.copyProperties(sponsorValidator, sponsor);

            sponsor.setStudents(students);
            sponsors.add(sponsor);
        }
        student.setSponsors(sponsors);
        studentService.save(student, validator.getCurrentSchoolGrade());
        return new ModelAndView("redirect:/app/students/");
    }

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView("students/index");
        List<Student> students = studentService.getStudents();
        mv.addObject("students",students);
        return mv;
    }

}
