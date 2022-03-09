package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.exception.ErrorRespons;
import com.svalero.deliveryAPI.exception.RestaurantNotFoundException;
import com.svalero.deliveryAPI.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public Restaurant getRestaurant(@PathVariable long id)throws RestaurantNotFoundException{
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
    public Restaurant removeRestaurant(@PathVariable long id)throws RestaurantNotFoundException {
        Restaurant restaurant = restaurantService.deleteRestaurant(id);
        return restaurant;
    }
    @PostMapping("/restaurants")
    public Restaurant addRestaurant(@RequestBody Restaurant restaurant) {//lo combierte a json
        Restaurant newRestaurant = restaurantService.addRestaurant(restaurant);
        return newRestaurant;
    }
    @PutMapping("/restaurant/{id}")
    public Restaurant modifyRestaurant(@RequestBody Restaurant restaurant, @PathVariable long id)throws  RestaurantNotFoundException {
        Restaurant newRestaurant = restaurantService.modifyRestaurant(id, restaurant);
        return newRestaurant;
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<ErrorRespons> handleRestaurantNotFoundException(RestaurantNotFoundException rnfe){
        ErrorRespons errorRespons = new ErrorRespons("404", rnfe.getMessage());

        return new ResponseEntity<>(errorRespons, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(Exception exception){
        ErrorRespons errorRespons = new ErrorRespons("000000", "Internal Server error   ");
        return new ResponseEntity<>(errorRespons, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
