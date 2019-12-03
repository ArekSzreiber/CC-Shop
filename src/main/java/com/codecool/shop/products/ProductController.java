package com.codecool.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller

public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String showProductsList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/products-list";
    }

    @PostMapping("/products")
    public String addNewCourse(@Valid @ModelAttribute("course") Product product,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products";
        } else {
            productService.save(product);
            return "redirect:/";
        }
    }

}
