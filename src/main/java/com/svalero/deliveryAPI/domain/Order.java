package com.svalero.deliveryAPI.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private long price;
    @Column
    private double weight;
    @Column
    private double ready;
    @Column
    private int time;
    @Column
    private int distance;

}
