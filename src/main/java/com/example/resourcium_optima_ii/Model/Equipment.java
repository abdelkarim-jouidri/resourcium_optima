package com.example.resourcium_optima_ii.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    @Enumerated(EnumType.STRING)
    private Availability availability;

    @Enumerated(EnumType.STRING)
    private Type type;


    public Equipment() {
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setType(Type type) {
        this.type = type;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public Availability getAvailability() {
        return availability;
    }

    public Type getType() {
        return type;
    }



    private enum Availability {
        AVAILABLE,
        IN_USE,
        IN_MAINTENANCE
    }

    private enum Type {
        JETABLE,
        NON_JETABLE
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", availability=" + availability +
                ", type=" + type +
                '}';
    }
}
