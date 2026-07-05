package com.example.racers_backend_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "race_results")
public class RaceResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resultId;

    private int grid_position;
    private int finishing_position;

    @ManyToOne
    @JoinColumn(name = "race_id")
    private Race race;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Drivers driver;

    public RaceResult(){}

    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public int getGrid_position() {
        return grid_position;
    }

    public void setGrid_position(int grid_position) {
        this.grid_position = grid_position;
    }

    public int getFinishing_position() {
        return finishing_position;
    }

    public void setFinishing_position(int finishing_position) {
        this.finishing_position = finishing_position;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Drivers getDriver() {
        return driver;
    }

    public void setDriver(Drivers driver) {
        this.driver = driver;
    }
}
