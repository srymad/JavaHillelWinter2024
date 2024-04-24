package org.example.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.controller.OrderController;
import org.example.dao.OrderRepository;
import org.example.entity.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private static final Logger loggerFile = LoggerFactory.getLogger(OrderService.class);

    private final OrderRepository orderRepository;

    public Order findOrderById(Long id){
        Optional<Order> order = orderRepository.findById(id);
        loggerFile.info("Service: order by id " + id + " was retrieved");
        return order.orElse(null);
    }

    public List<Order> findAllOrders(){
        loggerFile.info("Service: whole list of orders was retrieved");
        return orderRepository.findAll();
    }

    public Order save(Order order){
        loggerFile.info("Service: order with id " + order.getId() + " was created");
        return orderRepository.save(order);
    }

    public void deleteById(Long id){
        orderRepository.deleteById(id);
        loggerFile.info("Service: order with id " + id + " was deleted");
    }
}
