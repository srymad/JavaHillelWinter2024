package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dao.OrderRepository;
import org.example.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController()
public class OrderController {

    private OrderRepository orderRepository;

    @Autowired
    public OrderController(OrderRepository repository){
        orderRepository = repository;
    }

    @GetMapping("/orders/id/{id}")
    public Order getOrderById(@PathVariable("id") UUID id){
        return orderRepository.findOrderById(id);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        return orderRepository.findAllOrders();
    }

    @PostMapping("/orders/create")
    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

}
