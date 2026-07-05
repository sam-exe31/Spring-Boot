package org.example;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
// we can chnage the entity and table name separetly
// if you wanna workk with hibernate then we have to work with entity not table name
@Table(name = "alien_data")
public class Alien {

    @Id
    @Column(name = "a_id")
    private int u_id;
    @Column(name = "a_name")
    private String name;
    private String tech;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }
}
