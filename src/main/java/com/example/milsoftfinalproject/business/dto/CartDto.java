package com.example.milsoftfinalproject.business.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class CartDto {
    private long cartId;

    private String customerName;

    private long cardNumber;

    private long cartStatus;

}
