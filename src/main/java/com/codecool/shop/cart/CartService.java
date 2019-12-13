package com.codecool.shop.cart;

import com.codecool.shop.product.Product;
import org.springframework.stereotype.Service;

@Service
public interface CartService {

    void addProduct(Product product);



}
