package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "students")
    private List<Classroom> classrooms;

    @ManyToMany(fetch = FetchType.EAGER,cascade = {CascadeType.REFRESH, CascadeType.PERSIST})
    @JoinTable(name="student-sponsor", joinColumns = @JoinColumn(name="student"),inverseJoinColumns = @JoinColumn(name="sponsor"))
    private List<Sponsor> sponsors;

    @OneToMany(fetch = FetchType.EAGER)
    private List<SchoolReport> schoolReports;

    @ManyToOne
    private SchoolGrade currentSchoolGrade;
    @Column(unique = true)
    private String cpf;

    @OneToOne
    private User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
