package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {


}
