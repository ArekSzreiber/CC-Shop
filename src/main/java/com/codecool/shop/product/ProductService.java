package com.codecool.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Product save(Product product);

    Product findById(int id);
}
