package com.codecool.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProduct(Integer id);
}
