package br.com.siges.controllers;

import br.com.siges.exceptions.BDException;
import br.com.siges.models.Teacher;
import br.com.siges.services.DisciplineService;
import br.com.siges.services.TeacherService;
import br.com.siges.validators.TeacherValidator;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app/teachers")
public class TeacherController {
    @Autowired
    DisciplineService disciplineService;
    @Autowired
    TeacherService teacherService;
    @GetMapping("/create")
    public ModelAndView create(TeacherValidator teacherValidator){
        ModelAndView mv = new ModelAndView("teachers/create");
        mv.addObject("disciplines",disciplineService.listAll());
        return mv;
    }

    @PostMapping("save")
    public ModelAndView save(@Valid TeacherValidator teacherValidator, BindingResult result){
        if(result.hasErrors()){
            ModelAndView mv = new ModelAndView("teachers/create");
            mv.addObject("disciplines",disciplineService.listAll());
            return mv;
        }

        Teacher teacher = new Teacher();
        teacher.setName(teacherValidator.getName());
        try {
            teacherService.save(teacher,teacherValidator.getEligibleDisciplines());
        } catch (BDException e) {
            throw new RuntimeException(e);
        }

        return new ModelAndView("redirect:/app");
    }
}
