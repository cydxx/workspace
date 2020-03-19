package com.cydvv.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_ok"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    @HystrixCommand(fallbackMethod = "time_out_back", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String time_out(Integer id){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池"+Thread.currentThread().getName()+"time_out"+id+"\t"+"O(∩_∩)O哈哈~耗时3秒";
    }

    public String time_out_back(Integer id){
        return "线程池"+Thread.currentThread().getName()+"time_out"+id+"\t"+"o(╥﹏╥)o耗时3秒";
    }


}
