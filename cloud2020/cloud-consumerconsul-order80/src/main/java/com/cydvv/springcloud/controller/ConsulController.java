package com.cydvv.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsulController {
    public static final String PAYMENT_URL = "http://cloud-provider-consul";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/consul")
    public Object create(){
        return restTemplate.getForObject(PAYMENT_URL+"/payment/consul",String.class);
    }

}
