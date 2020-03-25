package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class PaymenthysController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/payment/hystris/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystris/timeout/{id}")
    public String time_out(@PathVariable("id") Integer id){
        return paymentService.time_out(id);
    }

    //==========
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
