package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.Rider;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RiderRepository extends CrudRepository<Rider,Long> {

    List<Rider> findAll();
    Rider findById(long id);
    List<Rider> findByVehicle(String vehicle);

    }