package br.com.siges.services;

import br.com.siges.models.Schedule;
import br.com.siges.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    @Autowired
    private ScheduleRepository scheduleRepository;
    public Schedule save(Schedule schedule){

        return scheduleRepository.save(schedule);

    }


}
