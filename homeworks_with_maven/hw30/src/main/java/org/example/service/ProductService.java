package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.dao.OrderRepository;
import org.example.dao.ProductRepository;
import org.example.entity.Order;
import org.example.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product findProductById(Long id){
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    public List<Product> findAllProducts(){
        return productRepository.findAll();
    }

    public Product save(Product product){
        return productRepository.save(product);
    }
}
