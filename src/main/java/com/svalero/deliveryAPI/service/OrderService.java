package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.dto.OrderDto;
import com.svalero.deliveryAPI.exception.OrderNotFoundException;
import com.svalero.deliveryAPI.exception.RestaurantNotFoundException;
import com.svalero.deliveryAPI.exception.RiderNotFoundException;
import com.svalero.deliveryAPI.exception.UserNotFoundException;

import java.util.List;

public interface OrderService {

    List<Order> findAll();
    Order findOrder(long id) throws OrderNotFoundException;
    List<Order> findByDistance(int distance);
    Order deleteOrder(long id) throws OrderNotFoundException;


    Order addOrder( Order order);

    Order addOrder(OrderDto orderDto) throws UserNotFoundException, RestaurantNotFoundException, RiderNotFoundException;

    Order modifyOrder(long id, Order newOrder) throws OrderNotFoundException;
}
