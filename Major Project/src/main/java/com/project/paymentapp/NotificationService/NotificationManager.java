package com.project.paymentapp.NotificationService;

public interface NotificationManager {
    void notifyUserCreate(String request);
    void notifyTransaction(String request);
}
