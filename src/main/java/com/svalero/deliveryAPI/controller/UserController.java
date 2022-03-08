package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.User;
import com.svalero.deliveryAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable long id){
        User user= userService.findById(id);
        return user;
    }
    @GetMapping("/user")
    public List<User> getUserBySurname(@RequestParam(name = "Surname", defaultValue = "")
                                                            String surname) {//?=
        List<User> users;
        if (surname.equals("")) {
            users= userService.findAll();
        } else {
            users = userService.findBySurname(surname);
        }
        return users;
    }
}
