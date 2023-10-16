package com.example.resourcium_optima_ii.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    private long id;

    private String name;

    private LocalDate Bought_In;

    public Product() {
    }

    public Product(long id, String name, LocalDate bought_In) {
        this.id = id;
        this.name = name;
        Bought_In = bought_In;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBought_In(LocalDate bought_In) {
        Bought_In = bought_In;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBought_In() {
        return Bought_In;
    }
}
