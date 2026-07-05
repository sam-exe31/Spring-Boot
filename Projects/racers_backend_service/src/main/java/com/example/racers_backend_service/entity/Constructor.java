package com.example.racers_backend_service.entity;

import jakarta.persistence.*;
import org.apache.tomcat.util.bcel.Const;

@Entity
@Table(name="constructors")

public class Constructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int constructor_id;

    @Column(nullable = false,length = 100)
    private String name;

    @Column (length = 50)
    private String nationality;

    @Column (length = 100)
    private String principal;

    public Constructor(){}

//    setting up getters and setters

    public int getConstructor_id() {
        return constructor_id;
    }
    public void setConstructor_id(int constructor_id) {
        this.constructor_id = constructor_id;
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
    public String getPrincipal() {
        return principal;
    }
    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
