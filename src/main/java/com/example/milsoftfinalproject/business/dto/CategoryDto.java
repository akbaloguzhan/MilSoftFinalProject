package com.example.milsoftfinalproject.business.dto;

import com.example.milsoftfinalproject.data.entity.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    private long categoryId;

    private String categoryName;

    private List<Product> productList;
}
