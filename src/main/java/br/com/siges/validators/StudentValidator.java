package br.com.siges.validators;

public class StudentValidator {

    private long id;
    private String name;

    private long currentSchoolGrade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCurrentSchoolGrade() {
        return currentSchoolGrade;
    }

    public void setCurrentSchoolGrade(long currentSchoolGrade) {
        this.currentSchoolGrade = currentSchoolGrade;
    }
}
