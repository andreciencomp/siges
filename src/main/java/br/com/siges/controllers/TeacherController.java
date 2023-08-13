package br.com.siges.controllers;

import br.com.siges.models.Teacher;
import br.com.siges.services.DisciplineService;
import br.com.siges.validators.TeacherValidator;
import jakarta.validation.Valid;
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
    @GetMapping("/create")
    public ModelAndView create(TeacherValidator teacherValidator){
        ModelAndView mv = new ModelAndView("teachers/create");
        mv.addObject("disciplines",disciplineService.listAll());
        return new ModelAndView("teachers/create");
    }

    @PostMapping("save")
    public ModelAndView save(@Valid TeacherValidator teacherValidator, BindingResult result){
        System.out.println(teacherValidator.getEligibleDisciplines().length);
        return new ModelAndView("redirect:/app");
    }
}
