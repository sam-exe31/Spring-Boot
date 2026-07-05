package org.Store.stationary_store.Entity;

import jakarta.persistence.*;
import lombok.Data;


import jakarta.persistence.Column;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    @Column(name = "category_id")
    private int cat_id;
    @Column(name = "category_name")
    private String cat_name;
}
