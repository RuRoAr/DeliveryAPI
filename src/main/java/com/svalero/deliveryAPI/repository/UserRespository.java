package com.svalero.deliveryAPI.repository;

import com.svalero.deliveryAPI.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User, Long> {
}
