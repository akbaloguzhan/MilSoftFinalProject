package com.example.milsoftfinalproject.data.repository;

import com.example.milsoftfinalproject.data.entity.Cart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends CrudRepository<Cart, Long> {
}
