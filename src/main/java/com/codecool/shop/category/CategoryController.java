package com.codecool.shop.category;

import com.codecool.shop.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public List<Category> showCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}/products")
    public List<Product> showProductsByCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        return category.getProducts();
    }
}
