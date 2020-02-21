package com.codecool.shop.category;

import com.codecool.shop.product.Product;
import com.codecool.shop.supplier.SupplierService;
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
    private SupplierService supplierService;

    public CategoryController(@Qualifier("categoryServiceImpl") CategoryService categoryService,
                              SupplierService supplierService) {
        this.categoryService = categoryService;
        this.supplierService = supplierService;

    }

    @GetMapping("/categories")
    public List<Category> showCategories() {
        return categoryService.getAllCategories();
//        List<Category> categories = categoryService.getAllCategories();
//        return categories;
    }

    //    @GetMapping("/categories/add")
//    public String addCategoryForm(Model model) {
//        Category category = new Category();
//        model.addAttribute("category", category);
//        return "categories/category-add";
//    }
//
//    @GetMapping("/categories/delete/{id}")
//    public String deleteCategory(@PathVariable int id) {
//        if (categoryService.findById(id).hasNoProduct()) {
//            categoryService.deleteById(id);
//        }
//        return "redirect:/categories";
//    }
//
//    @GetMapping("/categories/{id}/edit")
//    public String showEditCategoryForm(@PathVariable int id, Model model) {
//        Category category = categoryService.findById(id);
//        model.addAttribute("category", category);
//        return "categories/category-update";
//    }
//
//    @PostMapping("/categories")
//    public String addOrUpdateCategory(@Valid @ModelAttribute Category category,
//                                      BindingResult result) {
//        if (result.hasErrors()) {
//            return "categories/category-update";
//        } else {
//            categoryService.save(category);
//            return "redirect:/categories";
//        }
//    }
//
    @GetMapping("/categories/{id}/products")
    public List<Product> showProductsByCategory(@PathVariable int id) {
        Category category = categoryService.findById(id);
        return category.getProducts();
    }
}
