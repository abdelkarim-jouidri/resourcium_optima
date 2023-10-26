package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;

    private Status status;

    private LocalDate dueDate;
    @ManyToOne
    private Employee employee;

    public Task() {
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        switch (status) {
            case "ASSIGNED":
                this.status = Status.ASSIGNED;
                break;
            case "COMPLETED":
                this.status = Status.COMPLETED;
                break;
            case "IN_PROGRESS":
                this.status = Status.IN_PROGRESS;
                break;
            default:
                throw new IllegalArgumentException("Invalid status: " + status);
        }
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    private enum Status {
        ASSIGNED,
        IN_PROGRESS,
        COMPLETED
    }
}
