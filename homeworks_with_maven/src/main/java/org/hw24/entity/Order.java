package org.hw24.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Order {
    private UUID uuid;
    private Timestamp date;
    private double cost;
    private List<Product> products = new ArrayList<>();

    public static double getTotalCost(double cost, int count){
        return cost * count;
    }
}
