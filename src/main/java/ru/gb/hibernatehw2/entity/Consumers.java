package ru.gb.hibernatehw2.entity;

import javax.persistence.*;

@Entity
public class Consumers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Consumers() {

    }

    public Consumers(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Consumers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
