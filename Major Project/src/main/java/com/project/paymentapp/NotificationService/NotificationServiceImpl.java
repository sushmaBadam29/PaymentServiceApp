package com.ncr.paymentapp.NotificationService;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ncr.paymentapp.UserService.Entities.UserCreatedResponse;
import com.ncr.paymentapp.WalletService.Entity.WalletResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificationServiceImpl implements NotificationManager{
    ObjectMapper objectMapper = new ObjectMapper();
    @SneakyThrows
    @Override
    @KafkaListener(topics = "userTopic", groupId = "NotificationService")
    public void notifyUserCreate(String request) {
        UserCreatedResponse userCreatedResponse = objectMapper.readValue(request,UserCreatedResponse.class);
        log.info("user created username {}",userCreatedResponse.getUsername() );


    }

    @SneakyThrows
    @Override
    @KafkaListener(topics = "wallet", groupId = "NotificationService")
    public void notifyTransaction(String request) {
        WalletResponse walletResponse
                = objectMapper.readValue(request,WalletResponse.class);
        log.info("transaction created id {}",walletResponse.getTxId());

    }
}
