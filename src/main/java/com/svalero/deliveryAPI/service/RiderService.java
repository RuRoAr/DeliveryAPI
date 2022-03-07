package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.Rider;

import java.util.List;

public interface RiderService {

    List<Rider> findAll();
    Rider findById(long id);
    List<Rider> findByVehicle(String vehicle);

}
