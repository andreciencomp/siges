package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false)
    private java.lang.String name;
    @ManyToMany
    @JoinTable(name="teachers-disciplines", joinColumns = @JoinColumn(name="id_teacher"), inverseJoinColumns = @JoinColumn(name="id_discipline"))
    private List<String> eligibleDisciplines;
    private boolean active=true;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public List<String> getEligibleDisciplines() {
        return eligibleDisciplines;
    }

    public void setEligibleDisciplines(List<String> eligibleDisciplines) {
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
