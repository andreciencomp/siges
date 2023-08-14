package br.com.siges.controllers;

import br.com.siges.enums.DayOfWeek;
import br.com.siges.enums.Time;
import br.com.siges.models.Schedule;
import br.com.siges.services.ScheduleService;
import br.com.siges.validators.ScheduleValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/app/schedules")
public class ScheduleController {
    @Autowired
    ScheduleService scheduleService;
    @GetMapping("/create")
    public ModelAndView create(ScheduleValidator validator){
        DayOfWeek[] days = DayOfWeek.values();
        Time[] times = Time.values();
        ModelAndView mv = new ModelAndView("schedules/create");
        mv.addObject("days",days);
        mv.addObject("times", times);
        return mv;
    }

    @PostMapping("/save")
    public ModelAndView save(ScheduleValidator validator, BindingResult result){
        if(result.hasErrors()){
            return new ModelAndView("schedules/create");
        }
        Schedule schedule = new Schedule();
        BeanUtils.copyProperties(validator, schedule);
        scheduleService.save(schedule);


        return new ModelAndView("redirect:/app");
    }

}
