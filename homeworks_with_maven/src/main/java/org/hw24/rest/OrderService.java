package org.hw24.rest;

import org.hw24.repository.OrderRepository;

import java.util.UUID;

import static spark.Spark.get;
import static spark.Spark.post;


public class OrderService {
    private static OrderRepository orderRepository = new OrderRepository();

    public static void main(String[] args) {

        //get order by uuid
        get("/order/:uuid", (request, response) -> {
            response.type("application/json");
            UUID uuid = UUID.fromString(request.params(":uuid"));

            return orderRepository.getOrderById(uuid);
        });

        //get whole list of orders
        get("/orders", (request, response) -> {
            response.type("application/json");
            return orderRepository.getOrders();
        });

        //create new order
        post("/order", (request, response) ->{
            response.type("application/json");

            return orderRepository.createOrder(request);
        });
    }



}
