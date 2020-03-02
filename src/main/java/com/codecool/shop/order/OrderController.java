package com.codecool.shop.order;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @PostMapping("/orders")
    public Order takeOrder(@RequestBody Order order) {
        System.out.println(order);
        //todo validation and processing order
        //todo return information whether data was correct and was processed
        return order;
    }
}
