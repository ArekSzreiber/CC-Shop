package com.codecool.shop.cart;

import com.codecool.shop.product.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {

    void addProduct(Product product);

    List<Product> getAllProducts();

    int getNumberOfProductsInCart();



}
