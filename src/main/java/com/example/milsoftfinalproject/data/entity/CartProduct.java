package com.example.milsoftfinalproject.data.entity;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class CartProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cartProductId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private long salesQuantity;
}
