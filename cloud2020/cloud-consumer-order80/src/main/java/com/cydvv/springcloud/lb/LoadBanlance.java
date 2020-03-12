package com.cydvv.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBanlance {
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
