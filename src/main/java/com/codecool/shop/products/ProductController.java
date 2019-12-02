package com.codecool.shop.products;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class ProductController {
    @GetMapping("/")
    public String showProductsList() {
        return "products/products-list";
    }

}
