package br.com.siges.validators;

import br.com.siges.enums.DayOfWeek;
import br.com.siges.enums.Time;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ScheduleValidator {

    @NotNull
    @NotBlank
    private DayOfWeek dayOfWeek;


    private Time time;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
