package com.cydvv.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    //======================

    @HystrixCommand(fallbackMethod = "breaker_method",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id< 0){
            throw new RuntimeException("id 不能是负数");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"=====调用成功-流水号："+serialNum;
    }

    public String breaker_method(@PathVariable("id") Integer id){
        return "id 不能是负数，请重新输入===>"+id;
    }

}
