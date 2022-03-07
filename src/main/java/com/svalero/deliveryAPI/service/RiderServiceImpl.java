package com.svalero.deliveryAPI.service;


import com.svalero.deliveryAPI.domain.Rider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService{
    @Autowired
    private RiderService riderService;

    @Override
    public List<Rider> findAll() {
        return riderService.findAll();
    }

    @Override
    public Rider findById(long id) {
        return riderService.findById(id);
    }

    @Override
    public List<Rider> findByVehicle(String vehicle) {
        return riderService.findByVehicle(vehicle);
    }
}
