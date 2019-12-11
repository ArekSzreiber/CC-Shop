package com.codecool.shop.category;

import com.codecool.shop.supplier.SupplierService;
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
    private SupplierService supplierService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService,
                              SupplierService supplierService) {
        this.categoryService = categoryService;
        this.supplierService = supplierService;
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

    @PostMapping("/categories")
    public String addOrUpdateCategory(@Valid @ModelAttribute Category category,
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
        model.addAttribute("allSuppliers", supplierService.getAllSuppliers());

        model.addAttribute("qualifier", "categories");
        model.addAttribute("currentQualifiers", Collections.singletonList(categoryService.findById(id)));
        return "index";
    }
}
