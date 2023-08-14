package br.com.siges.validators;

import br.com.siges.enums.ClassroomStatus;

public class ClassroomValidator {

    private String name;

    private int capacity;

    private long schoolGrade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public long getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(long schoolGrade) {
        this.schoolGrade = schoolGrade;
    }
}
