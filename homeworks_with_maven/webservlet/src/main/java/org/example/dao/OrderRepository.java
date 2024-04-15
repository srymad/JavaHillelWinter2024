package org.example.dao;


import lombok.RequiredArgsConstructor;
import org.example.entity.Order;
import org.example.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepository{
    private final static HashMap<UUID, Order> orders = new HashMap<>();

    public Order findOrderById(UUID id) {
        System.out.println(id);
        System.out.println(orders.containsKey(id));
        System.out.println(orders.keySet().stream().toList());
        return orders.get(id);
    }

    public List<Order> findAllOrders() {
        return orders.values().stream().toList();
    }

    public Order save(Order order) {
        order.setId(UUID.randomUUID());
        return orders.put(order.getId(), order);
    }
}
