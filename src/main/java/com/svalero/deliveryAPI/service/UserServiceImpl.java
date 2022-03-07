package com.svalero.deliveryAPI.service;


import com.svalero.deliveryAPI.domain.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserService userService;
    @Override
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    public User findById(long id) {
        return userService.findById(id);
    }

    @Override
    public List<User> findBySurname(String surname) {
        return findBySurname(surname);
    }
}
