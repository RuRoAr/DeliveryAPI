package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Restaurant;
import lombok.Data;

import java.util.List;


public interface RestaurantService {

List<Restaurant> findAllRestaurants();
List<Restaurant> findByCategory(String category);
Restaurant findRestaurant(long id);


}
