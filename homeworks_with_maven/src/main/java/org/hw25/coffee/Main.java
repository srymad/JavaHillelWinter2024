package org.hw25.coffee;


import org.hw25.coffee.order.CoffeeOrderBoard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main {

    public static void main(String[] args) {
        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();
        coffeeOrderBoard.addOrder("Joe");
        coffeeOrderBoard.addOrder("Mike");
        coffeeOrderBoard.addOrder("Jack");
        coffeeOrderBoard.addOrder("Carrol");
        coffeeOrderBoard.addOrder("Kevin");

        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();

        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver(10);

        coffeeOrderBoard.draw();
    }
}