package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrder(long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> findByDistance(int distance) {
        return orderRepository.findByDistance(distance);
    }
}
