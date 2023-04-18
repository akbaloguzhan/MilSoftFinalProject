package com.example.milsoftfinalproject.business.dto;

import com.example.milsoftfinalproject.data.entity.Category;
import lombok.Data;

@Data
public class ProductDto {
    private long productId;

    private String productName;

    private double salesPrice;

    private Category category;
}
