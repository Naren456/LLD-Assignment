package org.example.service;

import org.example.model.PaymentStatus;

public class PaymentService {
    public PaymentStatus processPayment(String bookingId, double amount) {
        // Mocking payment gateway
        System.out.println("Processing payment for booking: " + bookingId + " Amount: " + amount);
        return PaymentStatus.SUCCESS;
    }
}
