package com.svalero.deliveryAPI.service;


import com.svalero.deliveryAPI.domain.User;
import com.svalero.deliveryAPI.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRespository userRespository;
    @Override
    public List<User> findAll() {
        return userRespository.findAll();
    }

    @Override
    public User findById(long id) {
        return userRespository.findById(id);
    }

    @Override
    public List<User> findBySurname(String surname) {
        return userRespository.findBySurname(surname);
    }
}
