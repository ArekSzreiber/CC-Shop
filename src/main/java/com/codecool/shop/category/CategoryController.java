package com.codecool.shop.category;

import com.codecool.shop.product.Product;
import com.codecool.shop.product.parameter.ParameterService;
import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CategoryController {
    private CategoryService categoryService;
    private ParameterService parameterService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService,
                              ParameterService parameterService) {
        this.categoryService = categoryService;
        this.parameterService = parameterService;
    }

    @GetMapping("/categories")
    public List<Category> showCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/categories/{id}/products")
    public List<Product> showProductsByCategory(@PathVariable int id,
                                                @RequestParam(required = false, name = "f") String filter) {
        Category category = categoryService.findById(id);
        if (filter == null) {
            return category.getProducts();
        } else {
            ParameterValue parameterValue = parameterService.findParameterValue(filter);
            return parameterService.filterByParameterValue(category.getProducts(), parameterValue);
        }

    }
}
