package com.cydvv.springcloud.controller;

import com.cydvv.springcloud.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SendMessageController
{

    @Autowired
    private IMessageService iMessageService;

    @GetMapping("/send/mes")
    public String sendMessage(){
        String send = iMessageService.send();
        return send;
    }
}
