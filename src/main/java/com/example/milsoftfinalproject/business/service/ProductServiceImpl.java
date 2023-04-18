package com.example.milsoftfinalproject.business.service;

import com.example.milsoftfinalproject.business.dto.CategoryDto;
import com.example.milsoftfinalproject.business.dto.ProductDto;
import com.example.milsoftfinalproject.data.entity.Category;
import com.example.milsoftfinalproject.data.entity.Product;
import com.example.milsoftfinalproject.data.repository.CategoryRepository;
import com.example.milsoftfinalproject.data.repository.ProductRepository;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void add(ProductDto productDto, long categoryId) {
        try {
            Product product = toEntity(productDto);

            Optional<Category> categoryById = categoryRepository.findById(categoryId);
            if (categoryById.isPresent()) {
                product.setCategory(categoryById.get());
                productRepository.save(product);
            }
            else
                throw new InvalidDataAccessApiUsageException("Product yanlis kategoride kaydedilmeye calisiliyor: " + categoryById);
        }

        catch (InvalidDataAccessResourceUsageException e) {
            System.out.println("Urun kaydedilme biciminde bir hata bulunmakta: " + e.getMessage());
        }
    }

    @Override
    public List<ProductDto> getProductsByCategoryId(long categoryId) {
        try {
            List<ProductDto> productDtoList = new ArrayList<>();
            Optional<Category> categoryById = categoryRepository.findById(categoryId);
            if (categoryById.isPresent()) {
                for (Product product : categoryById.get().getProductList()) {
                    productDtoList.add(toDto(product));
                }
                return productDtoList;
            }
            else
                throw new EmptyResultDataAccessException(1);
        }
        catch (DataAccessException e) {
            System.out.println("Kategori bulunamadi: " + e.getMessage());
            return null;
        }
    }

    @Override
    public ProductDto getProductById(long productId) {
        try {
            Optional<Product> productById = productRepository.findById(productId);
            if (productById.isPresent()) {
                return toDto(productById.get());
            }
            else
                throw new EmptyResultDataAccessException(1);
        }
        catch (DataAccessException e) {
            System.out.println("Bu id'yi iceren bir kategori bulunamadi: " + e.getMessage());
            return null;
        }
    }


    private Product toEntity(ProductDto productDto) {
        Product product = new Product();
        product.setProductId(productDto.getProductId());
        product.setProductName(productDto.getProductName());
        product.setCategory(productDto.getCategory());
        product.setSalesPrice(productDto.getSalesPrice());

        return product;
    }

    private ProductDto toDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProductId(product.getProductId());
        productDto.setProductName(productDto.getProductName());
        productDto.setCategory(product.getCategory());
        productDto.setSalesPrice(productDto.getSalesPrice());

        return productDto;
    }



}
