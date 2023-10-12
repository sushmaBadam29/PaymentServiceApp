package com.ncr.paymentapp.TransactionService.controller;

import com.ncr.paymentapp.TransactionService.manager.TransactionManager;
import com.ncr.paymentapp.TransactionService.models.TransactionRequest;
import com.ncr.paymentapp.TransactionService.models.TransactionResponse;
import com.ncr.paymentapp.UserService.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    @Autowired
    private TransactionManager transactionManager;

    @PostMapping("/transaction")
    ResponseEntity create(@RequestBody TransactionRequest transactionRequest, Authentication authentication){
        User fromUser = (User) authentication.getPrincipal();
       return ResponseEntity.ok(transactionManager.create(transactionRequest,fromUser.getUsername()));
    }

    @GetMapping("/transaction/{transaction_id}")
    ResponseEntity get(@PathVariable("transaction_id") String transactionId){
        try {
            TransactionResponse transactionResponse =
                    transactionManager.get(transactionId);
            return ResponseEntity.ok(transactionResponse);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
