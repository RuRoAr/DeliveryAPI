package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable long id){
        Order order= orderService.findOrder(id);
        return order;
    }
    @GetMapping("/order")
    public List<Order> getOrderByDistance(@RequestParam(name = "distance", defaultValue = "")int distace) {//?=
        List<Order> orders;
        if (distace != 0) {
            orders = orderService.findByDistance(distace);
        } else {
            orders = orderService.findAll();
        }
        return orders;
    }
    @DeleteMapping("/order/{id}")
    public Order removeOrder(@PathVariable long id) {
        Order order = orderService.deleteOrder(id);
        return order;
    }
    @PostMapping("/orders")
    public Order addOrder(@RequestBody Order order) {//lo combierte a json
        Order newOrder = orderService.addOrder(order);
        return newOrder;
    }
    @PutMapping("/order/{id}")
    public Order modifyOrder(@RequestBody Order order, @PathVariable long id) {
        Order newOrder = orderService.modifyOrder(id, order);
        return newOrder;
    }
}
