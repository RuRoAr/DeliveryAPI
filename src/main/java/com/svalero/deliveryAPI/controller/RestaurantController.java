package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurants")
    public List<Restaurant> getAllRestaurants(){
        List<Restaurant> restaurants = restaurantService.findAllRestaurants();
        return restaurants;
    }
    @GetMapping("/restaurant/{id}")
    public Restaurant getRestaurant(@PathVariable long id){
        Restaurant restaurant= restaurantService.findRestaurant(id);
        return restaurant;
    }
    @GetMapping("/restaurant")
    public List<Restaurant> getRestaurantByCategory( @RequestParam(name = "category", defaultValue = "0") String category) {//?=
        List<Restaurant> restaurants;
        if (category.equals("0")) {
            restaurants = restaurantService.findAllRestaurants();
        } else {
            restaurants = restaurantService.findByCategory(category);
        }
        return restaurants;
    }

    @DeleteMapping("/restaurant/{id}")
    public Restaurant removeRestaurant(@PathVariable long id) {
        Restaurant restaurant = restaurantService.deleteRestaurant(id);
        return restaurant;
    }
    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {//lo combierte a json
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return newRestaurant;
    }
    @PutMapping("/restaurant/{id}")
    public Restaurant modifyRestaurant(@RequestBody Restaurant restaurant, @PathVariable long id) {
        Restaurant newRestaurant = restaurantService.modifyRestaurant(id, restaurant);
        return newRestaurant;
    }
    }
