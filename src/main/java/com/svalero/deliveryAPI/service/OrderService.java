package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findOrder(long id);
    List<Order> findByDistance(int distance);
}
