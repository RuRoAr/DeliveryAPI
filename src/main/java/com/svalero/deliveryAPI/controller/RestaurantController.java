package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getRestaurantsByCategory(String category){
        List<Restaurant> restaurants = restaurantService.findByCategory(category);
        return restaurants;
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable long id){
        Restaurant restaurant= restaurantService.findRestaurant(id);
        return restaurant;
    }

}
