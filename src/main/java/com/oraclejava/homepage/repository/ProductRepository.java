package com.oraclejava.homepage.repository;

import com.oraclejava.homepage.dto.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
