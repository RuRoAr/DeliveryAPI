package com.svalero.deliveryAPI.service;


import com.svalero.deliveryAPI.domain.Rider;
import com.svalero.deliveryAPI.repository.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderServiceImpl implements RiderService{
    @Autowired
    private RiderRepository riderRepository;

    @Override
    public List<Rider> findAll() {
        return riderRepository.findAll();
    }

    @Override
    public Rider findById(long id) {
        return riderRepository.findById(id);
    }

    @Override
    public List<Rider> findByVehicle(String vehicle) {
        return riderRepository.findByVehicle(vehicle);
    }
}
