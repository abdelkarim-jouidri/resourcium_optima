package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }
}
