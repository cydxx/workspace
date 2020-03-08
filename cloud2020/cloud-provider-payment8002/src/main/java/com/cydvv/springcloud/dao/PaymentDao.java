package com.cydvv.springcloud.dao;

import com.cydvv.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentDao {

    Integer create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);
}
