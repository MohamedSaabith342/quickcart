package com.example.quickcart.entity;

import jakarta.persistence.*;

@Entity
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String comment;
    private Double rating;

    public ProductReview() {}

    public ProductReview(Long id, String comment, Double rating) {
        this.id = id;
        this.comment = comment;
        this.rating = rating;
    }

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Double getRating() { return rating; }
    public void setRating(Double rating) { this.rating = rating; }
}