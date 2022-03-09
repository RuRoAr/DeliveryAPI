package com.svalero.deliveryAPI.controller;


import com.svalero.deliveryAPI.domain.Order;
import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.User;
import com.svalero.deliveryAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        List<User> users = userService.findAll();
        return users;
    }
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
    @DeleteMapping("/user/{id}")
    public User removeUser(@PathVariable long id) {
        User user = userService.deleteUser(id);
        return user;
    }
    @PostMapping("/users")
    public User addUser(@RequestBody User user) {//lo combierte a json
        User newUser = userService.addUser(user);
        return newUser;
    }
    @PutMapping("/user/{id}")
    public User modifyUser(@RequestBody User user, @PathVariable long id) {
        User newUser = userService.modifyUser(id, user);
        return newUser;
    }
}
