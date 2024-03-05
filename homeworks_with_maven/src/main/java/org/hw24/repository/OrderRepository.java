package org.hw24.repository;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.hw24.entity.Order;
import org.hw24.entity.Product;
import spark.Request;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderRepository {

    private List<Order> orders = new ArrayList<>();

    public JsonElement getOrderById(UUID uuid){
        return new Gson().toJsonTree(orders.stream()
                .filter(o -> o.getUuid().equals(uuid))
                .findFirst().get());
    }

    public JsonElement getOrders(){
        return new Gson().toJsonTree(orders);
    }

    public JsonElement createOrder(Request request){
        Product product = new Gson().fromJson(request.body(), Product.class);
        product.setUuid(UUID.randomUUID());

        Order order = new Order(UUID.randomUUID(),
                new Timestamp(System.currentTimeMillis()),
                Order.getTotalCost(product.getCost(), product.getCount()),
                new ArrayList<Product>(List.of(product)));

        orders.add(order);

        return new Gson().toJsonTree(order);
    }

}
