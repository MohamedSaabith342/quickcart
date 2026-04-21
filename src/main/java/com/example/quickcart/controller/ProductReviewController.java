package com.example.quickcart.controller;


import com.example.quickcart.dto.ProductReviewDto;
import com.example.quickcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/products/reviews")
public class ProductReviewController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<?> addReview(@RequestBody ProductReviewDto reviewDto){
        productService.addReview(reviewDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Review Added");

    }
}
