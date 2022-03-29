package com.stephanie.Springboot.tutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//always returns response body
@RestController
public class HelloController {

    // @RequestMapping(value = "/", method = RequestMethod.GET)
    // OR
    @GetMapping("/")
    public String helloWorld(){
        return "Hello to the World of Spring Boot, Stephanie here";
    }
}
