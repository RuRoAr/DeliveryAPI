package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.Restaurant;
import com.svalero.deliveryAPI.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRespository extends CrudRepository<User, Long> {
    List<User> findAll();
    User findById(long id);
    List<User> findBySurname(String surname);
}
