package com.cydvv.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIS-PAYMENT",fallback = PaymentFallbackService.class)
public interface HysService {

    @GetMapping("/payment/hystris/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id);

    @GetMapping("/payment/hystris/timeout/{id}")
    public String time_out(@PathVariable("id")Integer id);
}
