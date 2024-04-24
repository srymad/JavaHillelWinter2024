package org.example.controller;

import org.example.entity.Order;
import org.example.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class OrderController {
    private static final Logger loggerFile = LoggerFactory.getLogger(OrderController.class);

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping("/orders/id/{id}")
    public Order getOrderById(@PathVariable("id") Long id){
        loggerFile.info("Order with id " + id + " was returned");
        return orderService.findOrderById(id);
    }

    @GetMapping("/orders")
    public List<Order> getAllOrders(){
        loggerFile.info("Whole list of orders was returned");
        return orderService.findAllOrders();
    }

    @PostMapping("/orders/create")
    public Order addOrder(@RequestBody Order order) {
        loggerFile.info("Order with id " + order.getId() + " was created");
        return orderService.save(order);
    }

    @PostMapping("/orders/delete/{id}")
    public Long deleteOrderById(@PathVariable("id") Long id) {
        orderService.deleteById(id);
        loggerFile.info("Order with id " + id + " was deleted");
        return id;
    }

}
