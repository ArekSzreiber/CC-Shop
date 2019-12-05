package com.codecool.shop.productCategories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductCategoryController {
    private ProductCategoryService categoryService;

    public ProductCategoryController(@Qualifier("productCategoryServiceImpl") ProductCategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        List<ProductCategory> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/categories-list";
    }

    @GetMapping("/categories/add")
    public String addCategoryForm(Model model) {
        ProductCategory productCategory = new ProductCategory();
        model.addAttribute("productCategory", productCategory);
        return "categories/categories-form";
    }

    @PostMapping("/categories/add")
    public String addCategory(@Valid @ModelAttribute("category") ProductCategory productCategory,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/add";
        } else {
            categoryService.save(productCategory);
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        categoryService.deleteById(id);
        return "redirect:/categories";
    }

    @GetMapping("/categories/edit")
    public String editCategory(@RequestParam("id") int id,
                                          Model model) {
        ProductCategory productCategory = categoryService.findById(id);
        model.addAttribute("productCategory", productCategory);
        return "categories/categories-form";
    }


}
