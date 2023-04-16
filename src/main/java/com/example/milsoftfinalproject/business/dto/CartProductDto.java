package com.example.milsoftfinalproject.business.dto;


import com.example.milsoftfinalproject.data.entity.Cart;
import com.example.milsoftfinalproject.data.entity.Product;
import jakarta.persistence.*;
import lombok.Data;

@Data
public class CartProductDto {
    private long cartProductId;

    private Cart cart;

    private Product product;

    private long salesQuantity;
}
