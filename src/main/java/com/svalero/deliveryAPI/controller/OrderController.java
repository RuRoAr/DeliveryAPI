package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
