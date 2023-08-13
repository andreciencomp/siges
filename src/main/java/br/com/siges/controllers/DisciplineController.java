package br.com.siges.controllers;

import br.com.siges.models.String;
import br.com.siges.services.DisciplineService;
import br.com.siges.validators.DisciplineValidator;
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
@RequestMapping("/app/disciplines")
public class DisciplineController {
    @Autowired
    DisciplineService disciplineService;
    @GetMapping("/create")
    public ModelAndView create(DisciplineValidator disciplineValidator){

        return new ModelAndView("disciplines/create");
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid DisciplineValidator disciplineData, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("disciplines/create");
        }
        String discipline = new String();
        BeanUtils.copyProperties(disciplineData, discipline);
        disciplineService.save(discipline);
        return new ModelAndView("redirect:/app");
    }
}
