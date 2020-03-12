package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.entities.CommonResult;
import com.cydvv.springcloud.entities.Payment;
import com.cydvv.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/create")
    public Object create(@RequestBody Payment payment){
        Integer integer = paymentService.create(payment);
        System.out.println("===========");
        if (integer>0){
            return new CommonResult<Payment>(200,"保存成功！"+serverPort);
        }
        return new CommonResult<Payment>(500,"插入失败！");
    }

    @GetMapping(value = "/get/{id}")
    public Object create(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment==null){
            return new CommonResult<Payment>(200,"没有对应数据！"+id,null);
        }
        return new CommonResult<Payment>(200,"获取成功！"+serverPort,payment);
    }
    @GetMapping("/lb")
    public String getPayment(){
        return serverPort;
    }
}
