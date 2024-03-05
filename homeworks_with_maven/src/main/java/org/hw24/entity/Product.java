package org.hw24.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {
    private UUID uuid;
    private String name;
    private double cost;
    private int count;
}
