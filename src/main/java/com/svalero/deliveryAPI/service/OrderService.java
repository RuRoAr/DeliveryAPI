package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.exception.OrderNotFoundException;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findOrder(long id) throws OrderNotFoundException;
    List<Order> findByDistance(int distance);
    Order deleteOrder(long id) throws OrderNotFoundException;


    Order addOrder( Order order);


    Order modifyOrder(long id, Order newOrder) throws OrderNotFoundException;
}
