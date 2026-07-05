package com.example.racers_backend_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "circuits")
public class Circuits {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int circuit_id;

    @Column (nullable = false,length=100)
    private String name;

    @Column(length = 100)
    private String location;

    @Column(length = 50)
    private String Country;

    private double length_km;

    private Circuits(){}

    public int getCircuit_id() {
        return circuit_id;
    }

    public void setCircuit_id(int circuit_id) {
        this.circuit_id = circuit_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public double getLength_km() {
        return length_km;
    }

    public void setLength_km(double length_km) {
        this.length_km = length_km;
    }
}
