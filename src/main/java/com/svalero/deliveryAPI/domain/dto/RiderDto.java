package com.svalero.deliveryAPI.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class RiderDto {


    private double price;
    private double weight;
    private boolean ready;
    private int time;
    private int distance;

}
