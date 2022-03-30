package com.oraclejava.homepage.service;

import java.util.List;
import java.util.Optional;

import com.oraclejava.homepage.dto.Product;
import com.oraclejava.homepage.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll() {
        List<Product> productList = productRepository.findAll();

        return productList;
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }
}
