package br.com.siges.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Sponsor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="sponsor-student", joinColumns = @JoinColumn(name="id_sponsor"),
            inverseJoinColumns = @JoinColumn(name="id_student"))
    private List<Student> students;

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
