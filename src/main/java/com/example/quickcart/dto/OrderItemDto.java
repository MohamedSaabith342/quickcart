package com.example.quickcart.dto;

import com.example.quickcart.entity.Product;
import jakarta.persistence.*;


public class OrderItemDto {


    private String name;
    private Integer quantity;
    private String image;
    private Double price;
    private Product product;


    public OrderItemDto(String name, Integer quantity, String image, Double price, Product product) {
        this.name = name;
        this.quantity = quantity;
        this.image = image;
        this.price = price;
        this.product = product;
    }

    public OrderItemDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}

