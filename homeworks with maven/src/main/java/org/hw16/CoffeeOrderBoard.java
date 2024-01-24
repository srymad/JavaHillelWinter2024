package org.hw16;

import java.util.TreeSet;

public class CoffeeOrderBoard{
    private TreeSet<Order> orders;

    public CoffeeOrderBoard() {
        orders = new TreeSet<>();
    }

    public boolean addOrder(String name){
        return orders.add(new Order(name));
    }

    public boolean deliver(){
        Order tempOrder = orders.first();

        return orders.remove(tempOrder);
    }

    public boolean deliver(int orderNumber){
        for (Order order: orders) {
            if(order.getCurrentOrderNumber() == orderNumber){
                orders.remove(order);
                return true;
            }
        }

        return false;

    }

    public void draw(){
        System.out.println("-".repeat(12) + "\nNum | Name\n" + "-".repeat(12));
        orders.forEach(System.out::println);
    }

    public TreeSet<Order> getOrders() {
        return orders;
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

    public String getCustomerName() {
        return customerName;
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
