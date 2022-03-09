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

    @Override
    public User deleteUser(long id) {
        User user = userRespository.findById(id);
        userRespository.delete(user);
        return user;
    }

    @Override
    public User addUser(User user) {
        return userRespository.save(user);
    }

    @Override
    public User modifyUser(long id, User newUser) {
        User user = userRespository.findById(id);
        user.setAddress(newUser.getAddress());
        user.setName(newUser.getName());
        user.setBirthDate(newUser.getBirthDate());
        user.setDni(newUser.getDni());
        user.setSurname(newUser.getSurname());
        return userRespository.save(user);
    }
}
