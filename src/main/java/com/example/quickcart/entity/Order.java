package com.example.quickcart.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItem;

    private Double totalItemsAmount;
    private Double textAmount;
    private Double totalAmount;
    private String status;
    private String orderNo;


    public Order(Long id,
                 List<OrderItem> orderItem,
                 Double textAmount,
                 Double totalItemsAmount,
                 Double totalAmount,
                 String status,
                 String orderNo) {
        this.id = id;
        this.orderItem = orderItem;
        this.textAmount = textAmount;
        this.totalItemsAmount = totalItemsAmount;
        this.totalAmount = totalAmount;
        this.status = status;
        this.orderNo = orderNo;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }

    public Double getTotalItemsAmount() {
        return totalItemsAmount;
    }

    public void setTotalItemsAmount(Double totalItemsAmount) {
        this.totalItemsAmount = totalItemsAmount;
    }

    public Double getTextAmount() {
        return textAmount;
    }

    public void setTextAmount(Double textAmount) {
        this.textAmount = textAmount;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
