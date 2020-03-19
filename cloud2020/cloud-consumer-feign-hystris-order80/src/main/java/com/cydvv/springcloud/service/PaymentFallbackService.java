package com.cydvv.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements HysService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "---------------fakk back ok";
    }

    @Override
    public String time_out(Integer id) {
        return "--------------------fall back out";
    }
}
