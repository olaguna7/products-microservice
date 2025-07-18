package com.oscar.productsmicroservice.repository;

import com.oscar.productsmicroservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
