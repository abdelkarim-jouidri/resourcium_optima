package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @OneToMany
    private Employee employee;

    public Department() {
    }
}
