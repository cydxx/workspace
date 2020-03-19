package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.service.HysService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
@DefaultProperties(defaultFallback = "time_oforbackut_back")
public class HysOrder80 {

    @Resource
    private HysService hysService;
    @GetMapping("/payment/hystris/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
       return hysService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystris/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "time_out_back", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "6000")})
    @HystrixCommand
    public String time_out(@PathVariable("id") Integer id){
        int a=1/0;
        return hysService.time_out(id);
    }
    public String time_out_back(@PathVariable("id") Integer id){
        return "helllo"+id;
    }

    public String time_oforbackut_back(){
        return "for back";
    }
}
