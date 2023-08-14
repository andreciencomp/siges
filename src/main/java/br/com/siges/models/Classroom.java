package br.com.siges.models;

import br.com.siges.enums.ClassroomStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;

    private int capacity;
    @Enumerated(EnumType.STRING)
    private ClassroomStatus status;
    @OneToMany(fetch = FetchType.EAGER)
    private List<TeacherBinding> teacherBinding;
    @ManyToOne
    private SchoolGrade schoolGrade;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="classroom-student", joinColumns = @JoinColumn(name="id_classroom"),
            inverseJoinColumns = @JoinColumn(name="id_student"))
    private List<Student> students;

    private int year;

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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ClassroomStatus getStatus() {
        return status;
    }

    public void setStatus(ClassroomStatus status) {
        this.status = status;
    }

    public List<TeacherBinding> getTeacherBinding() {
        return teacherBinding;
    }

    public void setTeacherBinding(List<TeacherBinding> teacherBinding) {
        this.teacherBinding = teacherBinding;
    }

    public SchoolGrade getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(SchoolGrade schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
