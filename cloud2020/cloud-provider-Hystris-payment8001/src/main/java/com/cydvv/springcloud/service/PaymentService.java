package com.cydvv.springcloud.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        return "线程池"+Thread.currentThread().getName()+"paymentInfo_ok"+id+"\t"+"O(∩_∩)O哈哈~";
    }

    public String time_out(Integer id){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池"+Thread.currentThread().getName()+"time_out"+id+"\t"+"O(∩_∩)O哈哈~耗时3秒";
    }
}
