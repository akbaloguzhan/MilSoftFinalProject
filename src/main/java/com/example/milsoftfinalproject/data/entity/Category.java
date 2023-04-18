package com.example.milsoftfinalproject.data.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    private String categoryName;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Product> productList;

}
