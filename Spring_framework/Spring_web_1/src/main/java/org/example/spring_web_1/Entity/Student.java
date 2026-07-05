package org.example.spring_web_1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Student {

    @Id
    private int id;
    private String name;
    private String city;
}
