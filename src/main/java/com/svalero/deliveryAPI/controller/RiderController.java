package com.svalero.deliveryAPI.controller;

import com.svalero.deliveryAPI.domain.Rider;
import com.svalero.deliveryAPI.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiderController {
    @Autowired
    private RiderService riderService;

    @GetMapping("/rider/{id}")
    public Rider getRider(@PathVariable long id){
        Rider rider= riderService.findById(id);
        return rider;
    }
    @GetMapping("/rider")
    public List<Rider> getRiderByVehicle(@RequestParam(name = "vehicle", defaultValue = "")
                                                            String vehicle) {//?=
        List<Rider> riders;
        if (vehicle.equals("")) {
            riders = riderService.findAll();
        } else {
            riders = riderService.findByVehicle(vehicle);
        }
        return riders;
    }
}
