package com.codecool.shop.supplier;

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
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(@Qualifier("supplierServiceImpl") SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public String showSuppliers(Model model) {
        List<Supplier> suppliers = supplierService.getAllSuppliers();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers-list";
    }

    @GetMapping("suppliers/add")
    public String addSupplierForm(Model model) {
        Supplier supplier = new Supplier();
        model.addAttribute("supplier", supplier);
        return "suppliers/supplier-add";
    }

    @PostMapping("/suppliers/add")
    public String addSupplier(@Valid @ModelAttribute("supplier") Supplier supplier,
                              BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/suppliers/add";
        } else {
            supplierService.save(supplier);
            return "redirect:/suppliers";
        }
    }

    @GetMapping("/suppliers/delete/{id}")
    public String deleteSupplier(@PathVariable int id) {
        if (supplierService.findById(id).hasNoProduct()) {
            supplierService.deleteById(id);
        }
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers/{id}/edit")
    public String showEditSupplierForm(@PathVariable int id, Model model) {
        Supplier supplier = supplierService.findById(id);
        model.addAttribute("supplier", supplier);
        return "suppliers/supplier-update";
    }

    @PostMapping("/suppliers/edit")
    public String editSupplier(@Valid @ModelAttribute Supplier supplier,
                                 BindingResult result) {
        if (result.hasErrors()) {
            return "suppliers/supplier-update";
        } else {
            supplierService.save(supplier);
            return "redirect:/suppliers";
        }
    }

    @GetMapping("/suppliers/{id}/products")
    public String showProductsBySupplier(@PathVariable int id, Model model) {
        model.addAttribute("allSuppliers", supplierService.getAllSuppliers());
        model.addAttribute("currentSuppliers", Collections.singletonList(supplierService.findById(id)));
        model.addAttribute("products", supplierService.findAllProductsBySupplierId(id));
        return "suppliers/products-by-supplier";
    }
    //TODO this routing should be merged with index
    @GetMapping("/suppliers/all/products")
    public String showAllProductsBySupplier(Model model) {
        model.addAttribute("allSuppliers", supplierService.getAllSuppliers());
        model.addAttribute("currentSuppliers", supplierService.getAllSuppliers());
        return "suppliers/products-by-supplier";
}

}
