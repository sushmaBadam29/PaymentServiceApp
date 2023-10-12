package com.project.paymentapp.UserService.manager;

import com.project.paymentapp.UserService.Entities.UserResponse;
import com.project.paymentapp.UserService.Entities.UserServiceRequest;

public interface UserService{
    void create(UserServiceRequest userServiceRequest);
    UserResponse get(String username);
}
