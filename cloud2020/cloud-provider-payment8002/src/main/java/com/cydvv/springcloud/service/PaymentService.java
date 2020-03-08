package com.cydvv.springcloud.service;

import com.cydvv.springcloud.entities.Payment;

public interface PaymentService {

    Integer create(Payment payment);

    Payment getPaymentById(Long id);
}
