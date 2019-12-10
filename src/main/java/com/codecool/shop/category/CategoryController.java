package com.codecool.shop.category;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Collections;
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
        model.addAttribute("category", category);
        return "categories/category-add";
    }

    @PostMapping("/categories/add")
    public String addCategory(@Valid @ModelAttribute("category") Category category,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/categories/add";
        } else {
            categoryService.save(category);
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/delete/{id}")
    public String deleteCategory(@PathVariable int id) {
        if (categoryService.findById(id).hasNoProduct()) {
            categoryService.deleteById(id);
        }
        return "redirect:/categories";
    }

    @GetMapping("/categories/{id}/edit")
    public String showEditCategoryForm(@PathVariable int id, Model model) {
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/category-update";
    }

    @PostMapping("/categories/edit")//TODO in my opinion renaming method name and changing mapping is wrong
    //TODO "edit" is needless
    //TODO "editCategory" is used also to add
    public String editCategory(@Valid @ModelAttribute Category category,
                               BindingResult result) {
        if (result.hasErrors()) {
            return "categories/category-update";
        } else {
            categoryService.save(category);
            return "redirect:/categories";
        }
    }

    @GetMapping("/categories/{id}/products")
    public String showProductsByCategory(@PathVariable int id, Model model) {
        model.addAttribute("allCategories", categoryService.getAllCategories());
        model.addAttribute("currentCategories", Collections.singletonList(categoryService.findById(id)));
        model.addAttribute("products", categoryService.findAllProductsByCategoryId(id));
        return "index";
    }
}