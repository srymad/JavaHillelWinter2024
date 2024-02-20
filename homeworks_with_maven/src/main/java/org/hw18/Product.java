package org.hw18;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Product {
    private int id;
    private String type;
    private double price;
    private boolean isDiscount;
    private LocalDate date;

    public Product() {}

    public Product(String type, double price, boolean isDiscount) {
        this.type = type;
        this.price = price;
        this.isDiscount = isDiscount;
    }

    public Product(String type, double price, boolean isDiscount, LocalDate date) {
        this.type = type;
        this.price = price;
        this.isDiscount = isDiscount;
        this.date = date;
    }

    public List<Product> findBookBySetPrice(List<Product> list){

        return list.stream()
                .filter(s -> s.type.equals("Book") && s.price > 250)
                .toList();
    }

    public List<Product> findBooksWithDiscount(List<Product> list){

        return list.stream()
                .filter(s -> s.type.equals("Book") && s.isDiscount)
                .map(s -> new Product("Book", s.price * 0.9, true))
                .toList();
    }

    public Product getTheCheapestBook(List<Product> list){
        return list.stream()
                .filter(s -> s.type.equals("Book"))
                .min(Comparator.comparing(Product::getPrice))
                .orElseThrow(() -> new NoSuchElementException("Product [Type: Book] not found"));
    }

    public List<Product> getLastThreeProductsByTime(List<Product> list){
        return list.stream()
                .sorted(Comparator.comparing(Product::getDate).reversed())
                .limit(3)
                .toList();
    }

    public double calculateProductsByFilters(List<Product> list){
        return list.stream()
                .filter(s -> s.type.equals("Book") && s.price <= 75 && s.date.getYear() == 2024)
                .mapToDouble(s -> s.price)
                .sum();
    }

    public Map<String, List<Product>> groupProductsByType(List<Product> list) {
        return list.stream()
                .collect(Collectors.groupingBy(Product::getType));
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public boolean isDiscount() {
        return isDiscount;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", isDiscount=" + isDiscount +
                ", date=" + date +
                '}';
    }
}
