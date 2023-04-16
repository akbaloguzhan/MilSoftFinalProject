package com.example.milsoftfinalproject.business.service;


import com.example.milsoftfinalproject.business.dto.CategoryDto;
import com.example.milsoftfinalproject.business.dto.ProductDto;

import java.util.List;

public interface ProductService {
    void add(ProductDto productDto, long categoryId);

    List<ProductDto> getProductsByCategoryId(long categoryId);

    ProductDto getProductById(long productId);
}
