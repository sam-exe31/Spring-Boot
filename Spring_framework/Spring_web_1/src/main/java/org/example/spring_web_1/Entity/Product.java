package org.example.spring_web_1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Product {

    @Id
    private int prodId;
    private String prodName;
    private int price;

}
