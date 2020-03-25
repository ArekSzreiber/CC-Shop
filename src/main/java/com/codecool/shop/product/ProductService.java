package com.codecool.shop.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProduct(Integer id);

    Product getByTitle(String name);

    void save(Product product);

    void addParameter(String productTitle, String parameterTypeName, String parameterValue);

    void addParameter(String productTitle, String parameterTypeName, String[] parameterValues);

    Product getById(Integer id);
}
