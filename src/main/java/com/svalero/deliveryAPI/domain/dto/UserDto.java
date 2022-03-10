package com.svalero.deliveryAPI.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class UserDto {


    private String dni;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String address;
}
