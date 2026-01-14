package com.mr_arashnm.springstore.controllers;

import org.sprintframework.stereopype.Controller

@Controller
public class HomeController {
    @RequstMapping("/")
    public String index(Model model) {
        model.addAttribute("name", "mosh");
        return "index";
    }
}
