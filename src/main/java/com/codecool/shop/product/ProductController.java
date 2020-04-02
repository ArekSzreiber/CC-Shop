package com.codecool.shop.product;

import com.codecool.shop.product.parameter.ParameterService;
import com.codecool.shop.product.parameter.ParameterValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {

    private ProductService productService;
    private ParameterService parameterService;

    @Autowired
    public ProductController(ProductService productService,
                             ParameterService parameterService) {
        this.productService = productService;
        this.parameterService = parameterService;
    }

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false, name = "f") String filter) {
        if (filter == null) {
            return this.productService.getAllProducts();
        } else {
            ParameterValue parameterValue = parameterService.findParameterValue(filter);
            return productService.getProducts(parameterValue);

        }
    }

    @GetMapping("/products/{id}")
    public Product getProducts(@PathVariable Integer id) {
        Optional<Product> optional = productService.getProduct(id);
        return optional.orElse(null);
    }

}
