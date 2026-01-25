package com.mr_arashnm.springstore.controllers;


import com.mr_arashnm.springstore.entities.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

public class MessageController {
    @RequestMapping("/hello")
    public Message sayHello() {
        return new Message("Hello World!");
    }
}
