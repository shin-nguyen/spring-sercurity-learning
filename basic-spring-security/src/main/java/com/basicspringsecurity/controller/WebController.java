package com.basicspringsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping(value = {"/", "/home"})
    public String homepage() {
        return "home";
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/admin/page")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/403")
    public String error(){
        return "403";
    }
}
