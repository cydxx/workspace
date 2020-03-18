package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.service.HysService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping("/consumer")
public class HysOrder80 {

    @Resource
    private HysService hysService;
    @GetMapping("/payment/hystris/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
       return hysService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystris/timeout/{id}")
    public String time_out(@PathVariable("id") Integer id){
        return hysService.time_out(id);
    }
}
