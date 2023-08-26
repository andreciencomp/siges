package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(name="cpf", nullable = false, unique = true, updatable = true)
    private String cpf;

    @Column(nullable = false)
    private String name;
    @ManyToMany(mappedBy = "sponsors",fetch = FetchType.EAGER)
    private List<Student> students;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sponsor-student", joinColumns = @JoinColumn(name="id_sponsor"),
            inverseJoinColumns = @JoinColumn(name="id_student"))
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    @OneToOne
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
