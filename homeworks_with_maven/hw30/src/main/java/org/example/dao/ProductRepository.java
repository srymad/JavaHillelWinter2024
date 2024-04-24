package org.example.dao;


import org.example.entity.Order;
import org.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
