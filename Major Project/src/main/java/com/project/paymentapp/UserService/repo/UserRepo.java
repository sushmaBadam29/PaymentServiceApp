package com.ncr.paymentapp.UserService.repo;

import com.ncr.paymentapp.UserService.Entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
