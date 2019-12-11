package com.codecool.shop.product;

import com.codecool.shop.category.Category;
import com.codecool.shop.category.CategoryService;
import com.codecool.shop.supplier.Supplier;
import com.codecool.shop.supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class ProductController {

    private ProductService productService;
    private CategoryService categoryService;
    private SupplierService supplierService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService, SupplierService supplierService) {
        this.productService = productService;
        this.categoryService = categoryService;
        this.supplierService = supplierService;
    }

    @GetMapping("/")
    public String showProductsByCategory(Model model,
                                         @RequestParam(required = false) String showBy) {
        //this 2 must be:
        List<Category> categories = categoryService.getAllCategories();
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("allCategories", categories);
        model.addAttribute("allSuppliers", suppliers);
        //presence of those 2 ale XOR-like:
        if ("suppliers".equals(showBy)) {
            model.addAttribute("currentSuppliers", suppliers);
        } else if ("categories".equals(showBy) || showBy == null || showBy.isEmpty()) {
            model.addAttribute("currentCategories", categories);
        }
        return "index";
    }

    @GetMapping("/products")
    public String showProductsList(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "products/products-list";
    }

    @GetMapping("/products/add")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "products/product-form";
    }

    @PostMapping("/products/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("categories", categoryService.getAllCategories());
            model.addAttribute("suppliers", supplierService.getAllSuppliers());
            return "products/product-form";
        } else {
            productService.save(product);
            return "redirect:/products";
        }
    }

    @GetMapping("/products/{id}/delete")
    public String showDeleteProductForm(@PathVariable int id) {
        productService.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}/edit")
    public String showEditProductForm(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("suppliers", supplierService.getAllSuppliers());
        return "products/product-form";
    }

}
