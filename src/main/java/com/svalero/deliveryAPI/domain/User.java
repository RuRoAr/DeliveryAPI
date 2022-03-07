package com.svalero.deliveryAPI.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String dni;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(name = "brith_date")
    @DateTimeFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;
    @Column
    private String address;

}
