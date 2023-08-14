package br.com.siges.models;

import jakarta.persistence.*;

@Entity
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    private float grade1;

    private float grade2;

    private float grade3;

    private float grade4;

    @ManyToOne
    private TeacherBinding teacherBinding;

    @ManyToOne
    private Discipline discipline;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getGrade1() {
        return grade1;
    }

    public void setGrade1(float grade1) {
        this.grade1 = grade1;
    }

    public float getGrade2() {
        return grade2;
    }

    public void setGrade2(float grade2) {
        this.grade2 = grade2;
    }

    public float getGrade3() {
        return grade3;
    }

    public void setGrade3(float grade3) {
        this.grade3 = grade3;
    }

    public float getGrade4() {
        return grade4;
    }

    public void setGrade4(float grade4) {
        this.grade4 = grade4;
    }

    public TeacherBinding getTeacherBinding() {
        return teacherBinding;
    }

    public void setTeacherBinding(TeacherBinding teacherBinding) {
        this.teacherBinding = teacherBinding;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }
}
