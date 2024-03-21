package org.hw25.coffee.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class CoffeeOrderBoard{
    private static final Logger loggerFile = LoggerFactory.getLogger("file.info");

    private TreeSet<Order> orders;

    public CoffeeOrderBoard() {
        orders = new TreeSet<>();
    }

    public boolean addOrder(String name){
        loggerFile.info("New order created with name: {}", name);
        return orders.add(new Order(name));
    }

    public boolean deliver(){
        Order tempOrder = orders.first();
        if(tempOrder == null){
            loggerFile.error("No orders are present");
            throw new RuntimeException();
        }else{
            loggerFile.info("The first order was delivered: {}", tempOrder);
        }
        return orders.remove(tempOrder);
    }

    public boolean deliver(int orderNumber){
        for (Order order: orders) {
            if(order.getCurrentOrderNumber() == orderNumber){
                orders.remove(order);
                loggerFile.info("Order with id {} was delivered", orderNumber);
                return true;
            }
        }
        loggerFile.error("No order with id {} is present", orderNumber);
        return false;

    }

    public void draw(){
        System.out.println("-".repeat(12) + "\nNum | Name\n" + "-".repeat(12));
        orders.forEach(System.out::println);
        loggerFile.info("List of orders was shown");
    }

}

class Order implements Comparable<Order>{
    private static int orderNumber;
    private int currentOrderNumber;
    private String customerName;

    public Order(String customerName) {
        this.customerName = customerName;
        ++orderNumber;
        currentOrderNumber = orderNumber;

    }

    public int getCurrentOrderNumber() {
        return currentOrderNumber;
    }

    @Override
    public int compareTo(Order order) {
        return this.currentOrderNumber - order.currentOrderNumber;
    }

    @Override
    public String toString() {
        return " " + currentOrderNumber + "  | " + customerName;
    }
}
