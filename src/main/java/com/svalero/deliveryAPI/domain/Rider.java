package com.svalero.deliveryAPI.domain;


import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "riders")

public class Rider {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String dni;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String vehicle;
    @Column
    private int maxSpeed;

}
