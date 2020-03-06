package com.codecool.shop.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {


    OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    @Override
    public boolean validate(Order order) {
        return order.getPersonalData().isValid()
                && order.getBillingAddress().isValid()
                && order.getShippingAddress().isValid();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }
}
