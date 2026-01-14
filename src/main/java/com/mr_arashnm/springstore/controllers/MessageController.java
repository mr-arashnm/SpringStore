package com.mr_arashnm.springstore.controllers;


import com.mr_arashnm.springstore.entities.Message;

@RestController
public Message MessageController {
    @RequestMapping("/hello")
    public String sayHello() {
        return Message("Hello World!");
    }
}
