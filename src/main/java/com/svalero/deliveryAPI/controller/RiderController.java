package com.svalero.deliveryAPI.controller;

import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.Rider;
import com.svalero.deliveryAPI.exception.ErrorRespons;
import com.svalero.deliveryAPI.exception.RiderNotFoundException;
import com.svalero.deliveryAPI.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RiderController {
    @Autowired
    private RiderService riderService;

    @GetMapping("/riders")
    public List<Rider> getAllRiders() {
        List<Rider> riders = riderService.findAll();
        return riders;
    }
    @GetMapping("/rider/{id}")
    public Rider getRider(@PathVariable long id)throws RiderNotFoundException{
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
    @DeleteMapping("/rider/{id}")
    public Rider removeRider(@PathVariable long id)throws RiderNotFoundException {
        Rider rider = riderService.deleteRider(id);
        return rider;
    }
    @PostMapping("/riders")
    public Rider addRider(@RequestBody Rider rider) {//lo combierte a json
        Rider newRider = riderService.addRider(rider);
        return newRider;
    }
    @PutMapping("/rider/{id}")
    public Rider modifyRider(@RequestBody Rider rider, @PathVariable long id)throws RiderNotFoundException {
        Rider newRider = riderService.modifyRider(id, rider);
        return newRider;
    }
    @ExceptionHandler(RiderNotFoundException.class)
    public ResponseEntity<ErrorRespons> handleRiderNotFoundException(RiderNotFoundException rinfe){
        ErrorRespons errorRespons = new ErrorRespons("404", rinfe.getMessage());
        return new ResponseEntity<>(errorRespons, HttpStatus.NOT_FOUND);
    }

    //TODO mas tipos de excepcions
    @ExceptionHandler
    public ResponseEntity<ErrorRespons> handleException(Exception exception){
        ErrorRespons errorRespons = new ErrorRespons("000000", "Internal Server error   ");
        return new ResponseEntity<>(errorRespons, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
