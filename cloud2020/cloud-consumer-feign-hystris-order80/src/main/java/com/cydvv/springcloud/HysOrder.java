package com.cydvv.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HysOrder {
    public static void main(String[] args) {
        SpringApplication.run(HysOrder.class,args);
    }
}
