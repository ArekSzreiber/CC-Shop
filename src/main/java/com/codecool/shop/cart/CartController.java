package com.codecool.shop.cart;

import com.codecool.shop.product.Product;
import com.codecool.shop.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class CartController {

    private CartService cartService;
    private ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/add-to-cart/product/{id}")
    public String addToCart(@PathVariable int id){
        cartService.addProduct(productService.findById(id));
        System.out.println("Product Added!");
        int numberOfProductsInCart = cartService.getNumberOfProductsInCart();
        String jsonToSend = "{\"number\": " + numberOfProductsInCart + "}";
        return jsonToSend;
    }

    @GetMapping("/cart")
    public String showProductsInCart(Model model) {
        List<Product> products = cartService.getAllProducts();
        model.addAttribute("products", products);
        return "cart/cart";
    }
}
