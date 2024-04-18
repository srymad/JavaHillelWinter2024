package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_date")
    private Date date;

    @Column(name = "cost")
    private double cost;

    @JoinTable(
            name = "order_x_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Product> products;

    public Order(Date date, double cost, List<Product> products){
        this.date = date;
        this.cost = cost;
        this.products = new ArrayList<>(products);
    }
}
