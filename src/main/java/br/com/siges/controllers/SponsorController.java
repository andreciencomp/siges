package br.com.siges.controllers;

import br.com.siges.validators.SponsorValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("app/sponsors")
public class SponsorController {

    public ModelAndView create(@Valid SponsorValidator validator, BindingResult result){

        return null;
    }
}
