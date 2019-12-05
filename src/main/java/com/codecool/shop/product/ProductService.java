package com.codecool.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    void save(Product product);

    void deleteById(int id);

    Product findById(int id);
}
