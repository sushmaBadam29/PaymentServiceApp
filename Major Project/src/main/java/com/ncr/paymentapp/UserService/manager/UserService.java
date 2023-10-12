package com.ncr.paymentapp.UserService.manager;

import com.ncr.paymentapp.UserService.Entities.UserResponse;
import com.ncr.paymentapp.UserService.Entities.UserServiceRequest;

public interface UserService{
    void create(UserServiceRequest userServiceRequest);
    UserResponse get(String username);
}
