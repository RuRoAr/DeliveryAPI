package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.exception.OrderNotFoundException;
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
    public Order findOrder(long id)throws OrderNotFoundException {
        return orderRepository.findById(id) //si no esta el objeto mandame esta excepcion
                .orElseThrow(()-> new OrderNotFoundException());
    }

    @Override
    public List<Order> findByDistance(int distance) {
        return orderRepository.findByDistance(distance);
    }

    @Override
    public Order deleteOrder(long id)throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException());

        orderRepository.deleteById(id);
        return order;
    }

    @Override
    public Order addOrder( Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order modifyOrder(long id, Order newOrder)throws OrderNotFoundException {
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new OrderNotFoundException());;
        order.setDistance(newOrder.getDistance());
        order.setPrice(newOrder.getPrice());
        order.setReady(newOrder.isReady());
        order.setTime(newOrder.getTime());
        order.setWeight(newOrder.getWeight());
        return orderRepository.save(order);
    }
}
