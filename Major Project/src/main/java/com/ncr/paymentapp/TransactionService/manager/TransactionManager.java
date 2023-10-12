package com.ncr.paymentapp.TransactionService.manager;

import com.ncr.paymentapp.TransactionService.models.TransactionRequest;
import com.ncr.paymentapp.TransactionService.models.TransactionResponse;

public interface TransactionManager {

    String create(TransactionRequest transactionRequest, String username);
    TransactionResponse get(String transactionId) throws Exception;
    void updateStatus(String updateRequest) throws Exception;
}
