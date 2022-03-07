package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();
    Order findById(long id);
    List<Order> findByDistance(int distance);
}
