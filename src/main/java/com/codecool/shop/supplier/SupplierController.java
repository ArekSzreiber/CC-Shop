package com.codecool.shop.supplier;

import com.codecool.shop.category.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
    private SupplierService supplierService;
    private CategoryService categoryService;

    public SupplierController(@Qualifier("supplierServiceImpl") SupplierService supplierService,
                              CategoryService categoryService) {
        this.supplierService = supplierService;
        this.categoryService = categoryService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> showSuppliers() {
        return supplierService.getAllSuppliers();
    }

//    @GetMapping("suppliers/add")
//    public String addSupplierForm(Model model) {
//        Supplier supplier = new Supplier();
//        model.addAttribute("supplier", supplier);
//        return "suppliers/supplier-add";
//    }

//    @PostMapping("/suppliers/add")
//    public String addSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
//                              BindingResult result) {
//        if (result.hasErrors()) {
//            return "redirect:/suppliers/add";
//        } else {
//            supplierService.save(supplier);
//            return "redirect:/suppliers";
//        }
//    }

//    @GetMapping("/suppliers/delete/{id}")
//    public String deleteSupplier(@PathVariable int id) {
//        if (supplierService.findById(id).hasNoProduct()) {
//            supplierService.deleteById(id);
//        }
//        return "redirect:/suppliers";
//    }

//    @GetMapping("/suppliers/{id}/edit")
//    public String showEditSupplierForm(@PathVariable int id, Model model) {
//        Supplier supplier = supplierService.findById(id);
//        model.addAttribute("supplier", supplier);
//        return "suppliers/supplier-update";
//    }

//    @PostMapping("/suppliers/edit")
//    public String editSupplier(@Valid @ModelAttribute Supplier supplier,
//                               BindingResult result) {
//        if (result.hasErrors()) {
//            return "suppliers/supplier-update";
//        } else {
//            supplierService.save(supplier);
//            return "redirect:/suppliers";
//        }
//    }

//    @GetMapping("/suppliers/{id}/products")
//    public String showProductsBySupplier(@PathVariable int id, Model model) {
//        model.addAttribute("allCategories", categoryService.getAllCategories());
//        model.addAttribute("allSuppliers", supplierService.getAllSuppliers());
//
//        model.addAttribute("qualifier", "suppliers");
//        model.addAttribute("currentQualifiers", Collections.singletonList(supplierService.findById(id)));
//        return "index";
//    }

}
