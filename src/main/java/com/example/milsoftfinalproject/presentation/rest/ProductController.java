package com.example.milsoftfinalproject.presentation.rest;

import com.example.milsoftfinalproject.business.dto.ProductDto;
import com.example.milsoftfinalproject.business.service.CategoryService;
import com.example.milsoftfinalproject.business.service.ProductService;
import com.example.milsoftfinalproject.data.entity.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {
    private ProductService productService;
    private CategoryService categoryService;

    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("products/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId (@PathVariable("categoryId") long categoryId) {
        List<ProductDto> productsByCategoryId = productService.getProductsByCategoryId(categoryId);
        return ResponseEntity.ok().body(productsByCategoryId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable("id") long id) {
        ProductDto productById = productService.getProductById(id);
        return ResponseEntity.ok().body(productById);
    }

    @PostMapping("/add/{categoryId}")
    public ResponseEntity<ProductDto> addProductByCategoryId (@RequestBody ProductDto productDto, @PathVariable("categoryId") long categoryId) {
        productService.add(productDto, categoryId);
        return ResponseEntity.ok().body(productDto);
    }


}
