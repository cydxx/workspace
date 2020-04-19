package com.cydvv.springcloud.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cydvv.springcloud.entities.CommonResult;


/**
 * @auther cyd
 * @create 2020-04-19 15:04
 */
public class CustomerBlockHandler
{
    public static CommonResult handlerException(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----1");
    }
    public static CommonResult handlerException2(BlockException exception)
    {
        return new CommonResult(4444,"按客戶自定义,global handlerException----2");
    }
}
