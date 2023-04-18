package com.example.milsoftfinalproject.business.service;

import com.example.milsoftfinalproject.business.dto.CategoryDto;
import com.example.milsoftfinalproject.business.dto.ProductDto;
import com.example.milsoftfinalproject.data.entity.Category;
import com.example.milsoftfinalproject.data.entity.Product;
import com.example.milsoftfinalproject.data.repository.CategoryRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> list() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        for (Category category : categoryRepository.findAll()) {
            categoryDtoList.add(toDto(category));
        }
        return categoryDtoList;
    }

    @Override
    public List<ProductDto> findProductsByCategory(long categoryId) {
        List <ProductDto> productDtoList = new ArrayList<>();

        Optional<Category> category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            for (Product product : category.get().getProductList()) {
                productDtoList.add(toDto(product));
            }
        }
        return productDtoList;
    }

    @Override
    public void add(CategoryDto categoryDto) {
        Category category = toEntity(categoryDto);
        categoryRepository.save(category);
    }

    @Override
    public Optional<Category> findCategory(long categoryId) {
        Optional<Category> categoryById = categoryRepository.findById(categoryId);
        return categoryById;
    }


    // ********************* toEntity and toDto functions *********************
    private Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryName(categoryDto.getCategoryName());
        category.setProductList(categoryDto.getProductList());

        return category;
    }

    private CategoryDto toDto(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryName(categoryDto.getCategoryName());
        categoryDto.setProductList(category.getProductList());

        return categoryDto;
    }

    private ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(productDto.getProductName());
        productDto.setCategory(product.getCategory());
        productDto.setSalesPrice(productDto.getSalesPrice());

        return productDto;
    }

    private Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setCategory(productDto.getCategory());
        product.setSalesPrice(productDto.getSalesPrice());

        return product;
    }
}
