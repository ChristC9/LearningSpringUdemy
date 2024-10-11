package com.chriscode.springrest.rest;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sayhello")
public class DemoRestController {
    // localhost:8080//sayhello/testing to send get request to this endpoint
    @GetMapping("testing")
    public String sayHello(){
        return "Hello World";
    }

}
