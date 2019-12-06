package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/products")
    public String showProductsList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products/products-list";
    }

    @GetMapping("/products/add")
    public String addProductForm(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "products/products-form";
    }

    @PostMapping("/products/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/add-product-form";
        } else {
            productService.save(product);
            return "redirect:/products";
        }
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/edit")
    public String showFormForEditMedicine(@RequestParam("id") int id,
                                          Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "products/products-form";
    }

}
