package com.example.milsoftfinalproject.data.repository;

import com.example.milsoftfinalproject.data.entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
}
