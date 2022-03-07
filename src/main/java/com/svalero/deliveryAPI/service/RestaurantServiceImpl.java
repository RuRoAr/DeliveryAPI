package com.svalero.deliveryAPI.service;


import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> findAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> findByCategory(String category) {
        return restaurantRepository.findByCategory(category);
    }

    @Override
    public Restaurant findRestaurant(long id) {
        return restaurantRepository.findById(id);
    }
}
