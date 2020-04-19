package com.cydvv.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.cydvv.springcloud.dao"})
public class MyBatisConfig {
}
