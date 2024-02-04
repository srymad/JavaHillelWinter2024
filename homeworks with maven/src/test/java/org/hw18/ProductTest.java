package org.hw18;


import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class ProductTest {

    Product product = new Product();

    @Test
    void findBookBySetPrice() {
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true),
                new Product("Book", 150, true),
                new Product("Backpack", 300, true),
                new Product("Book", 50, true)));

        List<Product> resultList = product.findBookBySetPrice(list);

        resultList.forEach(s -> {
            assertTrue(s.getType().equals("Book") && s.getPrice() > 250);
        });
    }

    @Test
    void findBooksWithDiscount() {
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true),
                new Product("Book", 150, true),
                new Product("Backpack", 300, false),
                new Product("Book", 50, true)));

        List<Product> resultList = product.findBooksWithDiscount(list);
        list = list.stream().filter(Product::isDiscount).toList();

        for (int i = 0; i < resultList.size(); i++) {
            assertEquals(resultList.get(i).getPrice(), list.get(i).getPrice() * 0.9);
        }
    }

    @Test
    void getTheCheapestBook() {
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true),
                new Product("Book", 150, true),
                new Product("Backpack", 300, true),
                new Product("Book", 50, true)));

        Product cheapestBook = product.getTheCheapestBook(list);

        assertEquals("Book", cheapestBook.getType());

        list.forEach(s -> {
            if(s.getType().equals("Book") && s.getPrice() < cheapestBook.getPrice()){
                fail();
            }
        });

    }

    @Test
    void getLastThreeProductsByTime() {
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true, LocalDate.of(2023, 10, 11)),
                new Product("Book", 150, true,LocalDate.of(2024, 1, 5)),
                new Product("Backpack", 300, true, LocalDate.of(2023, 12, 20)),
                new Product("Book", 50, true, LocalDate.of(2024, 2, 1))));

        List<Product> resultList = product.getLastThreeProductsByTime(list);

        assertEquals(3, resultList.size());
        assertEquals(resultList.get(0).getDate(), LocalDate.of(2024, 2, 1));
        assertEquals(resultList.get(1).getDate(), LocalDate.of(2024, 1, 5));
        assertEquals(resultList.get(2).getDate(), LocalDate.of(2023, 12, 20));
    }

    @Test
    void calculateProductsByFilters() {
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true, LocalDate.of(2024, 10, 11)),
                new Product("Book", 74, true,LocalDate.of(2024, 1, 5)),
                new Product("Backpack", 300, true, LocalDate.of(2023, 12, 20)),
                new Product("Book", 50, true, LocalDate.of(2024, 2, 1))));

        double result = product.calculateProductsByFilters(list);

        double check = 0;
        for (Product p:list) {
            if(p.getType().equals("Book") && p.getDate().getYear() == 2024 && p.getPrice() <= 75){
                check += p.getPrice();
            }
        }

        assertEquals(result, check);
    }

    @Test
    void groupProductsByType(){
        List<Product> list = new ArrayList<>(List.of(new Product("Book", 270, true, LocalDate.of(2024, 10, 11)),
                new Product("Book", 74, true,LocalDate.of(2024, 1, 5)),
                new Product("Toy", 300, true, LocalDate.of(2023, 12, 20)),
                new Product("Backpack", 50, true, LocalDate.of(2024, 2, 1))));

        Map<String, List<Product>> productMap = product.groupProductsByType(list);

        assertEquals(3, productMap.size());

        assertTrue(productMap.containsKey("Book"));
        assertEquals(2, productMap.get("Book").size());

        assertTrue(productMap.containsKey("Toy"));
        assertEquals(1, productMap.get("Toy").size());

        assertTrue(productMap.containsKey("Backpack"));
        assertEquals(1, productMap.get("Backpack").size());
    }
}