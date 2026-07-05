package org.Store.stationary_store.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Products {
    @Id
    @Column(name = "prod_id")
    private int prodId;

    private String name;
    private int price;
    private boolean isfeatured;

    @Column(name = "image_url")
    private String imageUrl;


    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;


}
