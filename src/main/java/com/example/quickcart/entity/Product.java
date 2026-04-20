package com.example.quickcart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name field is required")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Price field is required")
    @PositiveOrZero(message = "Value must be zero or greater than zero")
    private Double price;

    @NotBlank(message = "Description field is required")
    private String description;

    private Double ratings = 0.0;

    @NotBlank(message = "Seller field is required")
    private String seller;

    @NotNull(message = "Stock field is required")
    private Integer stock;

    private Integer numOfReviews = 0;

    // ✅ REQUIRED by JPA
    public Product() {}

    // Constructor
    public Product(Long id, String name, Double price, String description,
                   Double ratings, String seller, Integer stock, Integer numOfReviews) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.ratings = ratings;
        this.seller = seller;
        this.stock = stock;
        this.numOfReviews = numOfReviews;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getRatings() { return ratings; }
    public void setRatings(Double ratings) { this.ratings = ratings; }

    public String getSeller() { return seller; }
    public void setSeller(String seller) { this.seller = seller; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Integer getNumOfReviews() { return numOfReviews; }
    public void setNumOfReviews(Integer numOfReviews) { this.numOfReviews = numOfReviews; }
}

