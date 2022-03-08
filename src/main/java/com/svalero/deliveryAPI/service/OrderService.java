package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findOrder(long id);
    List<Order> findByDistance(int distance);
    Order deleteOrder(long id);


    Order addOrder( Order order);


    Order modifyOrder(long id, Order newOrder);
}
