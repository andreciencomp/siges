package br.com.siges.models;

import jakarta.persistence.*;

@Entity
public class String {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(nullable = false)
    private java.lang.String name;

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
}
