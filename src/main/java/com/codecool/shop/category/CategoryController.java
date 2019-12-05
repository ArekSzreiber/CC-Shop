package com.codecool.shop.category;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CategoryController {
    private CategoryService categoryService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/categories")
    public String showCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories/categories-list";
    }

    @GetMapping("/categories/add")
    public String addCategoryForm(Model model) {
        Category category = new Category();
        model.addAttribute("productCategory", category);
        return "categories/categories-form";
    }

    @PostMapping("/categories/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/products/add";
        } else {
            categoryService.save(category);
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
        Category category = categoryService.findById(id);
        model.addAttribute("productCategory", category);
        return "categories/categories-form";
    }


}
