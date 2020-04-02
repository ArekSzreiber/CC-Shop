package com.codecool.shop.supplier;

import com.codecool.shop.product.Product;
import com.codecool.shop.product.parameter.ParameterService;
import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SupplierController {
    private SupplierService supplierService;
    private ParameterService parameterService;

    public SupplierController(@Qualifier("supplierServiceImpl") SupplierService supplierService,
                              ParameterService parameterService) {
        this.supplierService = supplierService;
        this.parameterService = parameterService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}/products")
    public List<Product> getProductsBySupplier(@PathVariable int id,
                                               @RequestParam(required = false, name = "f") String filter) {
        Supplier supplier = supplierService.findById(id);
        if (filter == null) {
            return supplier.getProducts();
        } else {
            ParameterValue parameterValue = parameterService.findParameterValue(filter);
            return parameterService.filterByParameterValue(supplier.getProducts(), parameterValue);
        }

    }


}
