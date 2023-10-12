package com.project.paymentapp.TransactionService.manager;

import com.project.paymentapp.TransactionService.models.TransactionRequest;
import com.project.paymentapp.TransactionService.models.TransactionResponse;

public interface TransactionManager {

    String create(TransactionRequest transactionRequest, String username);
    TransactionResponse get(String transactionId) throws Exception;
    void updateStatus(String updateRequest) throws Exception;
}
