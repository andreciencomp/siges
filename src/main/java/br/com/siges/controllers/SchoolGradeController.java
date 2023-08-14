package br.com.siges.controllers;

import br.com.siges.models.SchoolGrade;
import br.com.siges.services.SchoolGradeService;
import br.com.siges.validators.SchoolGradeValidator;
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
@RequestMapping("/app/schoolgrades")
public class SchoolGradeController {

    @Autowired
    SchoolGradeService schoolGradeService;
    @GetMapping("/create")
    public ModelAndView create(){

        return new ModelAndView("school-grades/create");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid SchoolGradeValidator validator, BindingResult result){

        if(result.hasErrors()){
            return new ModelAndView("school-grades/create");
        }
        SchoolGrade schoolGrade = new SchoolGrade();
        BeanUtils.copyProperties(validator, schoolGrade);
        schoolGradeService.save(schoolGrade);
        return new ModelAndView("redirect:/app");
    }
}
