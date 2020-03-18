package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/payment/get/{id}")
    public Object create(@PathVariable("id") Long id){
        return paymentFeignService.create(id);
    }

    @GetMapping(value = "/payment/timeout")
    public String create(){
        return paymentFeignService.create();
    }
}
