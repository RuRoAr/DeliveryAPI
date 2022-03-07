package com.svalero.deliveryAPI.service;

import com.svalero.deliveryAPI.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(long id);
    List<User> findBySurname(String surname);
}
