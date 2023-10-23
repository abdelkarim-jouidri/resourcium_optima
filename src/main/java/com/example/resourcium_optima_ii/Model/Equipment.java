package com.example.resourcium_optima_ii.Model;


import jakarta.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Availability availability;

    private Type type;

    public Equipment() {
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public void setType(Type type) {
        this.type = type;
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
        PROJECTOR,
        BOARD,
        COMPUTER,
        CHAIR,
        MEETING_ROOM
    }
}
