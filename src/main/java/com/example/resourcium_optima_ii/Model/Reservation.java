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
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private ReservationType reservationType;

    private String name;
    public Reservation() {
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public String getName() {
        return name;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public void setReservationType() {
        this.reservationType = ReservationType.EQUIPMENT_ALLOCATION;
    }

    public void setName(String name) {
        this.name = name;
    }

    private enum ReservationType{
        TASK_ASSIGNMENT,
        EQUIPMENT_ALLOCATION
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user=" + user +
                ", equipment=" + equipment +
                ", reservationDate=" + reservationDate +
                ", returnDate=" + returnDate +
                ", reservationType=" + reservationType +
                ", name='" + name + '\'' +
                '}';
    }
}
