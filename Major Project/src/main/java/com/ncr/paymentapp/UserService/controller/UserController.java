package com.ncr.paymentapp.UserService.controller;


import com.ncr.paymentapp.UserService.Entities.UserServiceRequest;
import com.ncr.paymentapp.UserService.manager.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    @Qualifier("service1")
    private UserService userService;

    @PostMapping("/user")
    void create(@RequestBody UserServiceRequest userServiceRequest){
        userService.create(userServiceRequest);
    }

    @GetMapping("/user/{username}")
    ResponseEntity get(@PathVariable("username") String username){
       return ResponseEntity.ok(userService.get(username));
    }
}
