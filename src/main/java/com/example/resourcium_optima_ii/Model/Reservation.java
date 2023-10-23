package com.example.resourcium_optima_ii.Model;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Equipment equipment;

    private LocalDate reservationDate;

    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    public Reservation() {
    }


    private enum ReservationType{
        TASK_ASSIGNMENT,
        EQUIPMENT_ALLOCATION
    }
}
