package com.example.milsoftfinalproject.business.service;

import com.example.milsoftfinalproject.business.dto.CategoryDto;
import com.example.milsoftfinalproject.business.dto.ProductDto;
import com.example.milsoftfinalproject.data.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    List<CategoryDto> list();

    List<ProductDto> findProductsByCategory(long categoryId);

    void add(CategoryDto categoryDto);

    Optional<Category> findCategory(long categoryId);
}
