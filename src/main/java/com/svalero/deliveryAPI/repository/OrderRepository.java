package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    List<Order> findAll();
    Order findById(long id);
    List<Order> findByDistance(int distance);
}
