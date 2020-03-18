package com.codecool.shop.supplier;

import com.codecool.shop.product.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
    private SupplierService supplierService;

    public SupplierController(@Qualifier("supplierServiceImpl") SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}/products")
    public List<Product> getProductsBySupplier(@PathVariable int id) {
        return supplierService.findById(id).getProducts();
    }

}
