package com.oraclejava.homepage.service;

import java.util.List;
import java.util.Optional;

import com.oraclejava.homepage.dto.Product;
import com.oraclejava.homepage.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;



@Service
public class ProductService {
    
    @Autowired
    ProductRepository productRepository;

    public List<Product> findAll(int sortorder) {
        List<Product> productList = null;

        switch(sortorder) {
            case 1:  // no order
                productList = productRepository.findAll();
                break;
            case 2:  // 가격이 낮은 순
                productList = productRepository.findAll(Sort.by("price").ascending());
                break;
            case 3:  // 가격이 높은 순
                productList = productRepository.findAll(Sort.by("price").descending());
                break;
            default:
                productList = productRepository.findAll();

        }
        //List<Product> productList = productRepository.findAll();

        return productList;
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
}
