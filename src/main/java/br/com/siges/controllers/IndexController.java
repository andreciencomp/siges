package br.com.siges.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping
    public ModelAndView index(){

        ModelAndView mv = new ModelAndView("index");
        mv.addObject("titulo", "Hello World");
        return mv;


    }
}
