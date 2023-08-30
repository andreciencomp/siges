package br.com.siges.controllers;

import br.com.siges.models.Classroom;
import br.com.siges.models.SchoolGrade;
import br.com.siges.services.ClassroomService;
import br.com.siges.services.SchoolGradeService;
import br.com.siges.validators.ClassroomValidator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/app/classrooms")
public class ClassroomController {
    @Autowired
    SchoolGradeService schoolGradeService;

    @Autowired
    ClassroomService classroomService;
    @GetMapping("/create")
    public ModelAndView create(){
        List<SchoolGrade> schoolGrades = schoolGradeService.listAll();
        ModelAndView mv = new ModelAndView("classrooms/create");
        mv.addObject("schoolGrades",schoolGrades);

        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid ClassroomValidator validator, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("classrooms/create");
        }
        Classroom classroom = new Classroom();
        BeanUtils.copyProperties(validator, classroom);
        classroomService.save(classroom, validator.getSchoolGrade());

        return new ModelAndView("redirect:/app/classrooms/");
    }

    @GetMapping("/")
    public ModelAndView listAll(){

        List<Classroom> classrooms = classroomService.listAll();
        ModelAndView mv = new ModelAndView("classrooms/index");
        mv.addObject("classrooms", classrooms);
        return mv;
    }

}
