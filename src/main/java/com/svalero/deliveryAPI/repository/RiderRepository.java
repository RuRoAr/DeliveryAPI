package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Rider;
import org.springframework.data.repository.CrudRepository;

public interface RiderRepository extends CrudRepository<Rider,Long> {
}
