package com.codecool.shop.order;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    List<Order> orders = new ArrayList<>();

    @PostMapping("/orders")
    public Order takeOrder(@RequestBody Order order) {
        orders.add(order);
        System.out.println(order.toString());
        System.out.println(orders.size());
        //todo validation and processing order
        //todo return information whether data was correct and was processed
        return order;
    }
}
