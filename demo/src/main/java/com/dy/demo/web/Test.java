package com.dy.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test {

    @RequestMapping("/test/{value}")
    public String test(@PathVariable(name = "value") String param){
        return "你好 再见"+param;
    }

}
