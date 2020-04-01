package com.cydvv.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Nacos83Main {
    public static void main(String[] args) {
        SpringApplication.run(Nacos83Main.class,args);
    }
}
