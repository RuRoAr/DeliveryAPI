package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.dto.OrderDto;
import com.svalero.deliveryAPI.exception.*;
import com.svalero.deliveryAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/orders")
    public List<Order> getAllRestaurants() {
        List<Order> orders = orderService.findAll();
        return orders;
    }

    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable long id) throws OrderNotFoundException{
        Order order= orderService.findOrder(id);
        return order;
    }
    @GetMapping("/order")
    public List<Order> getOrderByDistance(@RequestParam(name = "distance", defaultValue = "")int distance) {//?=
        List<Order> orders;
        if (distance != 0) {
            orders = orderService.findByDistance(distance);
        } else {
            orders = orderService.findAll();
        }
        return orders;
    }
    @DeleteMapping("/order/{id}")
    public Order removeOrder(@PathVariable long id) throws OrderNotFoundException {
        Order order = orderService.deleteOrder(id);
        return order;
    }
//    @PostMapping("/orders")
//    public Order addOrder(@RequestBody Order order) {//lo combierte a json
//        Order newOrder = orderService.addOrder(order);
//        return newOrder;
//    }
    @PostMapping("/orders")
    public Order addOrder(@RequestBody OrderDto orderDto)throws UserNotFoundException,
            RestaurantNotFoundException, RiderNotFoundException {//lo combierte a json
//        Order newOrder = orderService.addOrder(orderDto);
//        return newOrder;
        return orderService.addOrder(orderDto);
    }

    @PutMapping("/order/{id}")
    public Order modifyOrder(@RequestBody Order order, @PathVariable long id)throws OrderNotFoundException {
        Order newOrder = orderService.modifyOrder(id, order);
        return newOrder;
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorRespons> handleOrderNotFoundException(OrderNotFoundException ornfe){
        ErrorRespons errorRespons = new ErrorRespons("404", ornfe.getMessage());
        return new ResponseEntity<>(errorRespons, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(Exception exception){
        ErrorRespons errorRespons = new ErrorRespons("000000", "Internal Server error   ");
        return new ResponseEntity<>(errorRespons, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
