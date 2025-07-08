package com.example.prasanna.swagger_docs.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String helloWorld(){
        return "Hello I am spring boot from Docker !";
    }

    @GetMapping
    public void hello(){};

}
