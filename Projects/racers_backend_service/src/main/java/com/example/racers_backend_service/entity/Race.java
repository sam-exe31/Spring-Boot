package com.example.racers_backend_service.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "races")

public class Race {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int race_id;

    @Column(nullable = false)
    private int year;

    @Column(nullable = false)
    private int round;

    private LocalDate raceDate;

    @ManyToOne
    @JoinColumn(name = "circuit_id")
    private Circuits circuits;

    public Race(){}

    public int getRace_id() {
        return race_id;
    }

    public void setRace_id(int race_id) {
        this.race_id = race_id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public LocalDate getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(LocalDate raceDate) {
        this.raceDate = raceDate;
    }

    public Circuits getCircuit() {
        return circuits;
    }

    public void setCircuit(Circuits circuits) {
        this.circuits = circuits;
    }
}
