package homeworks.hw13.coffee;

import homeworks.hw13.coffee.order.CoffeeOrderBoard;

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
        coffeeOrderBoard.deliver(4);

        coffeeOrderBoard.draw();

    }
}
