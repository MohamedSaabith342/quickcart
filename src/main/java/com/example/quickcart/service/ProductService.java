package com.example.quickcart.service;

import com.example.quickcart.entity.Product;
import com.example.quickcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        List<Product> products =  productRepository.findAll();
        return products;
    }

}
