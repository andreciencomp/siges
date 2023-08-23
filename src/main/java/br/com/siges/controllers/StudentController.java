package br.com.siges.controllers;

import br.com.siges.models.SchoolGrade;
import br.com.siges.models.Student;
import br.com.siges.services.SchoolGradeService;
import br.com.siges.services.StudentService;
import br.com.siges.validators.StudentValidator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/app/students")
public class StudentController {

    @Autowired
    SchoolGradeService schoolGradeService;
    @Autowired
    StudentService studentService;
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView mv = new ModelAndView("students/create");
        List<SchoolGrade> schoolGrades = schoolGradeService.listAll();
        mv.addObject("schoolGrades", schoolGrades);
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid StudentValidator validator, BindingResult result){
        Student student = new Student();
        BeanUtils.copyProperties(validator, student);
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
