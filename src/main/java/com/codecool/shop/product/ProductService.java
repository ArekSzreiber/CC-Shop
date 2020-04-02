package com.codecool.shop.product;

import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ProductService {
    List<Product> getAllProducts();

    Optional<Product> getProduct(Integer id);

    Product getByTitle(String name);

    void save(Product product);

    void addParameters(String productTitle, String parameterTypeName, String parameterValue);

    void addParameters(String productTitle, String parameterTypeName, String[] parameterValues);

    Product getById(Integer id);

    List<Product> getProducts(ParameterValue parameterValue);
}
