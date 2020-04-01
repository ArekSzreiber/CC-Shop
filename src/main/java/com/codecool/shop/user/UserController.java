package com.codecool.shop.user;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://e:4200")
public class UserController {
    private UserService userService;

    public UserController(@Qualifier("userServiceImpl") UserService userService) {
        this.userService = userService;
    }

/*    @GetMapping("/suppliers")
    public List<Supplier> getSuppliers() {
        return supplierService.getAllSuppliers();
    }

    @GetMapping("/suppliers/{id}/products")
    public List<Product> getProductsBySupplier(@PathVariable int id) {
        return supplierService.findById(id).getProducts();
    }
*/
}
