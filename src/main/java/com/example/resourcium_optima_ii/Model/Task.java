package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    private Status status;
    @ManyToOne
    private Employee employee;

    private enum Status {
        ASSIGNED,
        IN_PROGRESS,
        COMPLETED
    }
}
