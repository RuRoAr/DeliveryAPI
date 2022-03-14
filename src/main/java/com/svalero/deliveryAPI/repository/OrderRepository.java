package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.dto.OrderDto;
import com.svalero.deliveryAPI.exception.RestaurantNotFoundException;
import com.svalero.deliveryAPI.exception.RiderNotFoundException;
import com.svalero.deliveryAPI.exception.UserNotFoundException;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {



    List<Order> findAll();
    List<Order> findByDistance(int distance);
}
