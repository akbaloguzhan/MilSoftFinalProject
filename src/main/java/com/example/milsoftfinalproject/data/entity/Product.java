package com.example.milsoftfinalproject.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    private String productName;

    private double salesPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
