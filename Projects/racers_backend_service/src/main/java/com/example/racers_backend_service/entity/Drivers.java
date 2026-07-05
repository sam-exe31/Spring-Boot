package com.example.racers_backend_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="drivers")
public class Drivers {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int driver_id;

    @Column(length = 50 ,nullable = false)
    private String name;

    @Column(length = 50)
    private String nationality;

    private LocalDate dob;

    @ManyToOne
    @JoinColumn(name = "constructor_id")
    private Constructor constructor;

    public Drivers(){}

    public int getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(int driver_id) {
        this.driver_id = driver_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Constructor getConstructor() {
        return constructor;
    }

    public void setConstructor(Constructor constructor) {
        this.constructor = constructor;
    }
}

