package br.com.siges.controllers;

import br.com.siges.models.User;
import br.com.siges.services.UserService;
import br.com.siges.validators.UserValidator;
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
@RequestMapping("app/users")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/create")
    ModelAndView create(UserValidator user){

        return new ModelAndView("users/create");
    }

    @PostMapping("/save")
    ModelAndView save(@Valid UserValidator userData, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("users/create");
        }

        User user = new User();
        BeanUtils.copyProperties(userData,user);
        try {
            userService.saveAdmins(user, userData.getRoleName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new ModelAndView("redirect:/app");

    }
}
