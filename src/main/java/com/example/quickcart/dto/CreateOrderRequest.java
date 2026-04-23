package com.example.quickcart.dto;

import com.example.quickcart.entity.OrderItem;

import java.util.List;

public class CreateOrderRequest {
    private List<OrderItemDto> orderItems;

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
