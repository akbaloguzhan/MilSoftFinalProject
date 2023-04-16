package com.example.milsoftfinalproject.presentation.rest;

import com.example.milsoftfinalproject.business.dto.CategoryDto;
import com.example.milsoftfinalproject.business.dto.ProductDto;
import com.example.milsoftfinalproject.business.service.CategoryService;
import com.example.milsoftfinalproject.data.entity.Category;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<CategoryDto> findAllCategories () {
        return categoryService.list();
    }


    @PostMapping("/add-category")
    public String addCategory (@RequestBody CategoryDto categoryDto) {
        categoryService.add(categoryDto);
        return "Kategori basariyla eklendi.";
    }
}
