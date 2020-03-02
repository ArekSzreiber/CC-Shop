package com.codecool.shop.order;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OrderController {

    @PostMapping("/personalData")
    public PersonalData takeOrder(@RequestBody PersonalData personalData) {
        System.out.println(personalData);
        return personalData;
    }
}
