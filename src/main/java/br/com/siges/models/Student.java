package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<Classroom> classrooms;

    @ManyToMany(mappedBy = "students", fetch = FetchType.EAGER)
    private List<Sponsor> sponsors;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SchoolReport> schoolReports;

    @ManyToOne
    private SchoolGrade currentSchoolGrade;

    @OneToOne
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Classroom> getClassrooms() {
        return classrooms;
    }

    public void setClassrooms(List<Classroom> classrooms) {
        this.classrooms = classrooms;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }

    public List<SchoolReport> getSchoolReports() {
        return schoolReports;
    }

    public void setSchoolReports(List<SchoolReport> schoolReports) {
        this.schoolReports = schoolReports;
    }

    public SchoolGrade getCurrentSchoolGrade() {
        return currentSchoolGrade;
    }

    public void setCurrentSchoolGrade(SchoolGrade currentSchoolGrade) {
        this.currentSchoolGrade = currentSchoolGrade;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
