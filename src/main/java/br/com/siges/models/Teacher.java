package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="teacher-discipline", joinColumns = @JoinColumn(name="id_teacher"),
            inverseJoinColumns = @JoinColumn(name="id_discipline"))
    private List<Discipline> eligibleDisciplines;
    private boolean active=true;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

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

    public List<Discipline> getEligibleDisciplines() {
        return eligibleDisciplines;
    }

    public void setEligibleDisciplines(List<Discipline> eligibleDisciplines) {
        this.eligibleDisciplines = eligibleDisciplines;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
