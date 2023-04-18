package com.example.milsoftfinalproject.data.repository;

import com.example.milsoftfinalproject.data.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartProductRepository extends CrudRepository<CartProduct, Long> {
}
