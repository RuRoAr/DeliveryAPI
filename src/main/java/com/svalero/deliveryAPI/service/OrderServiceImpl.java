package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderService orderService;

    @Override
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @Override
    public Order findOrder(long id) {
        return orderService.findOrder(id);
    }

    @Override
    public List<Order> findByDistance(int distance) {
        return orderService.findByDistance(distance);
    }
}
