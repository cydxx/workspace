package com.cydvv.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Slf4j
@RestController
public class ConsumerOrderController {
    public static final String PAYMENT_URL = "http://cloud-provider-payment";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/zk")
    public Object create(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/zk",String.class);
    }
}
