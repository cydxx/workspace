package com.cydvv.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Provider9001Main {
    public static void main(String[] args) {
        SpringApplication.run(Provider9001Main.class,args);
    }
}
