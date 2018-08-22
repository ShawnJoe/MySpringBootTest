package com.example.demo.cotroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloWorld {
    @RequestMapping("hello")
    public String hello() {
        return "hello world test";
    }
}
