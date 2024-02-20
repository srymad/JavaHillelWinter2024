package org.hw16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CoffeeOrderBoardTest {

    @Test
    void testAddOrderByName() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        String customerName1 = "Mike";

        assertEquals(0, orderBoard.getOrders().size());

        assertTrue(new CoffeeOrderBoard().addOrder(customerName1));

        orderBoard.addOrder(customerName1);

        assertEquals(orderBoard.getOrders().first().getCustomerName(), customerName1);
        assertEquals(1, orderBoard.getOrders().size());
    }

    @Test
    void testAddOrderByOrder(){
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        assertEquals(0, orderBoard.getOrders().size());

        Order order = new Order("John");
        orderBoard.getOrders().add(order);

        assertTrue(orderBoard.getOrders().contains(order));
        assertEquals(1, orderBoard.getOrders().size());
    }

    @Test
    void testDeliverFirstWithName() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.addOrder("Moe");

        assertTrue(orderBoard.deliver());
        assertEquals(0, orderBoard.getOrders().size());
    }

    @Test
    void testDeliverFirstWithOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();

        Order order = new Order("Jack");
        orderBoard.getOrders().add(order);

        assertTrue(orderBoard.deliver());
        assertFalse(orderBoard.getOrders().contains(order));
        assertEquals(0, orderBoard.getOrders().size());
    }

    @Test
    void testDeliverByIdWithName() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        orderBoard.addOrder("Finn");
        orderBoard.addOrder("Kevin");


        assertTrue(orderBoard.deliver(2));
        assertEquals(1, orderBoard.getOrders().size());
    }

    @Test
    void testDeliverByIdWithOrder() {
        CoffeeOrderBoard orderBoard = new CoffeeOrderBoard();
        Order order1 = new Order("Max");
        Order order2 = new Order("Alex");

        orderBoard.getOrders().add(order1);
        orderBoard.getOrders().add(order2);

        assertTrue(orderBoard.deliver(order2.getCurrentOrderNumber()));
        assertEquals(1, orderBoard.getOrders().size());
    }


}