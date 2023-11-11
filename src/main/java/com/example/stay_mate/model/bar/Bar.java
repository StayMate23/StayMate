package com.example.stay_mate.model.bar;

import jakarta.persistence.*;

@Entity
@Table(name = "bar")
public class Bar {
    @Column(name = "bar_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    public Bar(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Bar() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
