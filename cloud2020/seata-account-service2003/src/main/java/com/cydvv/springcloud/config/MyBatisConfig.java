package com.cydvv.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan({"com.cdyvv.springcloud.dao"})
public class MyBatisConfig {
}
