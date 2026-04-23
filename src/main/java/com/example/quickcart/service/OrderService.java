package com.example.quickcart.service;

import com.example.quickcart.dto.CreateOrderRequest;
import com.example.quickcart.dto.OrderCreated;
import com.example.quickcart.dto.OrderItemDto;
import com.example.quickcart.entity.Order;
import com.example.quickcart.entity.OrderItem;
import com.example.quickcart.entity.Product;
import com.example.quickcart.repository.OrderRepository;
import com.example.quickcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    public OrderCreated createOrder(CreateOrderRequest orderRequest) {
        Order order = new Order();
        order.setStatus("PENDING");
        double totalItemsAmount = 0;

        for(OrderItemDto item: orderRequest.getOrderItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setName(item.getName());
            orderItem.setPrice(item.getPrice());
            orderItem.setImage(item.getImage());
            orderItem.setQuantity(item.getQuantity());

            Product product = productRepository.findById(item.getProductId()).orElseThrow(() -> new RuntimeException("Id not Found"));
            orderItem.setProduct(product);

            totalItemsAmount += item.getPrice()*item.getQuantity();
            order.getOrderItems().add(orderItem);

        }

        order.setTotalItemsAmount(totalItemsAmount);
        double totalAmount = 0;
        double taxAmount = totalItemsAmount*0.1;
        totalAmount = totalItemsAmount + taxAmount;
        order.setTaxAmount(taxAmount);
        order.setTotalAmount(totalAmount);
        String refId = UUID.randomUUID().toString();
        order.setReferenceId(refId);

        orderRepository.save(order);
        return new OrderCreated(refId);

    }

    public Order getOrder (String referenceId){
        Order order = orderRepository.findByReferenceId(referenceId).orElseThrow(() -> new RuntimeException("No Order Found"));
        return order;
    }


}
