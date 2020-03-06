package com.codecool.shop.order;

import org.springframework.stereotype.Service;

@Service
public interface OrderService {
    boolean validate(Order order);

    Order save(Order order);
}
