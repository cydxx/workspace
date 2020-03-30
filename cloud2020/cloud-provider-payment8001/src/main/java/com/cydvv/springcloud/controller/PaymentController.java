package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.entities.CommonResult;
import com.cydvv.springcloud.entities.Payment;
import com.cydvv.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/discover")
    public Object discover(){
        List<String> services = discoveryClient.getServices();
        for (String element: services) {
            log.info("=========element"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }

    @GetMapping("/lb")
    public String getPayment(){
        return serverPort;
    }

    @GetMapping(value = "/timeout")
    public String create(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
    @GetMapping("/zipkin")
    public String paymentZipkin() {
        return "hellp zipkin";
    }
}
