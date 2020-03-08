package com.cydvv.springcloud.service.impl;

import com.cydvv.springcloud.dao.PaymentDao;
import com.cydvv.springcloud.entities.Payment;
import com.cydvv.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService
{
    @Resource
    private PaymentDao paymentDao;

    @Override
    public Integer create(Payment payment) {
        Integer integer = paymentDao.create(payment);
        return integer;
    }

    @Override
    public Payment getPaymentById(Long id) {
        Payment payment = paymentDao.getPaymentById(id);
        return payment;
    }
}
