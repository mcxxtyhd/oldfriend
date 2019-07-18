package com.feng.oldfriend.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/theo")
    public String test(){
        return "123asdasdasdasdasd";
    }
}
