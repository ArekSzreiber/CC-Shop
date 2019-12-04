package com.codecool.shop.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller

public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String showProductsList(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products/products-list";
    }

    //adding new product form
    @GetMapping("/products/add-product-form")
    public String addProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "products/products-form";
    }

    @PostMapping("/products")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/add-product-form";
        } else {
            productService.save(product);
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete")
    public String delete(@RequestParam("id") int id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/edit")
    public String showFormForEditMedicine(@RequestParam("id") int id,
                                          Model theModel) {
        Product product = (Product) productService.findById(id);
        theModel.addAttribute("product", product);
        return "products/products-form";
    }

}
