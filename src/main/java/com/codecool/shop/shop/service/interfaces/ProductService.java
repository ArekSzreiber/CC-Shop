package com.codecool.shop.shop.service.interfaces;

import com.codecool.shop.shop.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {

    List<Product> findAll();

    Product findById(int id);

    void save(Product category);

    void deleteById(int id);

}


