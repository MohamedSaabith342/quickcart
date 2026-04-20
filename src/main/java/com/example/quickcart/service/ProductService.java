package com.example.quickcart.service;

import com.example.quickcart.entity.Product;
import com.example.quickcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Map<String, Object> getAllProducts(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = productRepository.findAll(pageable);

        Map<String, Object> response = new HashMap<>();
        response.put("products", products.getContent());
        response.put("totalProducts", products.getTotalElements());
        response.put("totalPages", products.getTotalPages());
        response.put("currentPage", products.getNumber());

        return response;
    }

    public Product getProductById(Long id){
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with the id " + id));
    }
}