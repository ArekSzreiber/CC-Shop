package com.codecool.shop.shop.controller;

import com.codecool.shop.shop.entity.Product;
import com.codecool.shop.shop.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String findAll(Model model) {
        List<Product> products = this.productService.findAll();
        return "products/products-list";
    }
}

/*
@Controller
public class CategoryController {

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAll(Model model){
        List<Category> categories = this.categoryService.findAll();
        model.addAttribute("categories", categories);
        return "categories/categories-list";
    }

/*
    @GetMapping("/categories/{id}")
    public String findById(@PathVariable int id){
        this.categoryService.findById(id);
        return "categories/category";
    }*/

/*
    @GetMapping("/categories/show-categories-form")
    public String showAddCategoryForm(Model model){
        Category category = new Category();
        model.addAttribute("category", category);
        return "categories/categories-form";
    }

    @PostMapping("/categories/add-category")
    public String addCategory(@Valid @ModelAttribute("category") Category category, BindingResult result){
        if(result.hasErrors()){
            return "categories/categories-form";
        }
        else{this.categoryService.save(category);}

        return "redirect:/categories";
    }

    @GetMapping("/categories/show-edit-form")
    public String showEditCategoryForm(@RequestParam("categoryIdToEdit") int id, Model model){
        Category category = this.categoryService.findById(id);
        model.addAttribute("category", category);
        return "categories/categories-form";
    }

    @PutMapping("/categories/categoriesToEdit")
    public void updateCategory(@RequestBody Category category){
        this.categoryService.save(category);
    }

    @GetMapping("/categories/delete")
    public String delete(@RequestParam("categoryIdToDelete") int id){
        this.categoryService.deleteById(id);
        return "redirect:/categories";
    }

}


*/
