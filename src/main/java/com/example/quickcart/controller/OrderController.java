package com.example.quickcart.controller;

import com.example.quickcart.dto.CreateOrderRequest;
import com.example.quickcart.entity.Order;
import com.example.quickcart.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequest orderRequest){

        Order order = orderService.createOrder(orderRequest);
        return ResponseEntity.ok().body(order);


    }

    @GetMapping("/{referenceId}")
    public ResponseEntity<Order> getOrder(@PathVariable String referenceId){
        Order order = orderService.getOrder(referenceId);
        return ResponseEntity.ok().body(order);
    }

}




